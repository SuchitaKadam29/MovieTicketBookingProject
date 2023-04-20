package com.spring.movieticketbooking.service;

import java.util.List;

import com.spring.movieticketbooking.dto.BookingDTO;
import com.spring.movieticketbooking.entity.Booking;
import com.spring.movieticketbooking.exception.MovieException;

/*
 * Author - Suchita Kadam
 * 9 April 2023
 * 
 */
public interface IBookingService {

	public Booking bookTicket(BookingDTO bookings) throws MovieException;

	public List<Booking> getAllMyBookings();

	public String cancelMyBooking(int bookingId) throws MovieException;

}
