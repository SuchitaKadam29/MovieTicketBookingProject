package com.spring.movieticketbooking.serviceImpl;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.movieticketbooking.dto.BookingDTO;
import com.spring.movieticketbooking.entity.Booking;
import com.spring.movieticketbooking.entity.Shows;
import com.spring.movieticketbooking.exception.MovieException;
import com.spring.movieticketbooking.repo.BookingRepository;
import com.spring.movieticketbooking.repo.ShowsRepository;
import com.spring.movieticketbooking.repo.TheaterRepository;
import com.spring.movieticketbooking.service.IBookingService;

/*
 * Author - Suchita Kadam
 * 13 April 2023
 * 
 */
@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	BookingRepository bookingRepo;

	@Autowired
	ShowsRepository showsRepo;

	@Autowired
	TheaterRepository theaterRepo;

	
	public Booking bookTicket(BookingDTO bookings) throws MovieException {
		Shows show = showsRepo.findById(bookings.getShowId()).orElseThrow(() -> new MovieException("Invalid ShowID"));

		LocalDateTime showDateTime = show.getShowDate().toLocalDate().atTime(show.getShowTime().toLocalTime());
		LocalDateTime now = LocalDateTime.now();
		String paymentMethod = bookings.getPaymentMethod();

		int theatreId = show.getTheater().getTheaterId();
		double ticketPrice = show.getTheater().getTicketPrice();
		Long noOfBookedSeats = bookingRepo.getBookedCount(show.getShowId());
		Long totalCapacity = theaterRepo.getTotalCapacity(theatreId);
		int availableSeats = (int) (totalCapacity - noOfBookedSeats);

		if (availableSeats <= 0) {
			throw new MovieException("House full");
		}

		int seatNo = bookings.getSeatNo();
		if (seatNo > totalCapacity || seatNo <= 0) {
			throw new MovieException("Invalid Seat Number");
		}

		if (bookingRepo.getSeatNo(show.getShowId(), seatNo) != 0) {
			throw new MovieException("Seat already booked");
		}

		if (showDateTime.isBefore(now)) {
			throw new MovieException("Film already started");
		}

		PaymentMethod payment = PaymentMethod.fromString(paymentMethod);
		if (payment == null) {
			throw new MovieException("Payment method not supported");
		}

		Booking booking = new Booking();
		booking.setSeatNo(seatNo);
		booking.setBookingDate(Date.valueOf(now.toLocalDate()));
		booking.setCustomerId(SecurityContextHolder.getContext().getAuthentication().getName());
		booking.setPaymentMethod(paymentMethod);
		booking.setShow(show);
		booking.setTotalAmount(ticketPrice);

		show.setAvailableSeats(availableSeats - 1);

		return bookingRepo.save(booking);
	}

	enum PaymentMethod {
		CreditCard("CreditCard"), DebitCard("DebitCard"), UPI("UPI");

		private final String value;

		PaymentMethod(String value) {
			this.value = value;
		}

		public static PaymentMethod fromString(String value) {
			for (PaymentMethod paymentMethod : PaymentMethod.values()) {
				if (paymentMethod.value.equals(value)) {
					return paymentMethod;
				}
			}
			return null;
		}
	}
	@Override
	public List<Booking> getAllMyBookings() {

		String customerId = SecurityContextHolder.getContext().getAuthentication().getName();
		return bookingRepo.findByCustomerId(customerId);
	}


	@Transactional
	@Override
	public String cancelMyBooking(int bookingId) throws MovieException {
		String customerId = SecurityContextHolder.getContext().getAuthentication().getName();

		Shows show = bookingRepo.getShow(bookingId, customerId);
		System.out.println(show);
		if (show != null) {
			Date showDate = show.getShowDate();
			Time showTime = show.getShowTime();
			LocalDateTime showDateAndTime = showDate.toLocalDate().atTime(showTime.toLocalTime());
			LocalDateTime now = LocalDateTime.now();
			int availableSeats = show.getAvailableSeats();

			if (showDateAndTime.isAfter(now)) {

				bookingRepo.deleteByIdAndCustomerId(bookingId, customerId);
				show.setAvailableSeats(availableSeats + 1);
				showsRepo.save(show);
				return "Booking is cancelled and you will get the refund in 2-3 working days";

			} else {

				System.out.println("You cannot cancel the Show, its Already Started");
				throw (new MovieException("You cannot cancel the Show, its Already Started"));
				// return "You cannot cancel the Show, its Already Started";
			}
		} else {
			System.out.println("Cannot find a show with the booking Id");
			throw (new MovieException("Cannot find a show with the booking Id"));
			// return "Cannot find a show with the booking Id";
		}

	}
}