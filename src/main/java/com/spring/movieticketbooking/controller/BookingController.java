package com.spring.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movieticketbooking.dto.BookingDTO;
import com.spring.movieticketbooking.entity.Booking;
import com.spring.movieticketbooking.exception.MovieException;
import com.spring.movieticketbooking.service.IBookingService;




/*
 * Author - Suchita Kadam
 * 12 April 2023
 * 
 */

@RestController
@RequestMapping("/movies")
public class BookingController {

	@Autowired
	IBookingService bookingServices;

	@PostMapping("/bookmovieticket")
	public Booking bookTicket(@RequestBody BookingDTO booking) throws MovieException {
		return bookingServices.bookTicket(booking);
	}

	@GetMapping("/bookinghistory")
	public List<Booking> getAllBookings() {
		return bookingServices.getAllMyBookings();
	}

	@DeleteMapping("/cancelbooking/{bookingId}")
	public String cancelBooking(@PathVariable int bookingId) throws MovieException {
		return bookingServices.cancelMyBooking(bookingId);

	}

}
