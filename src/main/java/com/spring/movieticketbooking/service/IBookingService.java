package com.spring.movieticketbooking.service;

import java.util.List;

import com.spring.movieticketbooking.dto.BookingDTO;
import com.spring.movieticketbooking.entity.Cinema;
import com.spring.movieticketbooking.exception.MovieException;

/*
 * Author - Suchita Kadam
 * 9 April 2023
 * 
 */
public interface IBookingService {

	public Cinema bookTicket(BookingDTO bookings) throws MovieException;

	public List<Cinema> getAllMyBookings();

	public String cancelMyBooking(int bookingId) throws MovieException;

}
