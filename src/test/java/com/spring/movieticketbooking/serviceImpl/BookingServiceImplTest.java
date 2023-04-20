package com.spring.movieticketbooking.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.spring.movieticketbooking.dto.BookingDTO;
import com.spring.movieticketbooking.entity.Booking;
import com.spring.movieticketbooking.exception.MovieException;


@SpringBootTest
class BookingServiceImplTest {
	
	@Autowired
	BookingServiceImpl bookingServiceImpl;

	@Test
	void testBookTicket() throws MovieException {
		
		BookingDTO bookdto = new  BookingDTO();
		bookdto.setPaymentMethod("CreditCard");
		bookdto.setSeatNo(45);
		bookdto.setShowId(2);
		
		Booking booking = bookingServiceImpl.bookTicket(bookdto);
		assertNotNull(booking);
		
	}

	@Test
	void testGetAllMyBookings() {
		
		List<Booking> list = bookingServiceImpl.getAllMyBookings();
		assertNotNull(list);

		
	}

	@Test
	void testCancelMyBooking() throws MovieException {
	String str = bookingServiceImpl.cancelMyBooking(3);
		
		assertEquals("Booking is cancelled and you will get the refund in 2-3 working days" , str);
		
	}

}
