package com.spring.movieticketbooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.movieticketbooking.entity.Cinema;
import com.spring.movieticketbooking.entity.Showss;

/*
 * Author - Suchita Kadam
 * 8 April 2023
 * 
 */
@Repository
public interface BookingRepository extends JpaRepository<Cinema, Integer> {

	// To find number of tickets sold out for a show
	@Query("SELECT COUNT(b) FROM Cinema b WHERE b.show.id = :showId")
	public Long getBookedCount(@Param("showId") int showId);

	// To check whether seat is already booked or not
	@Query("SELECT COUNT(b) FROM Cinema b WHERE b.show.id = :showId AND b.seatNo = :seatNo")
	public Long getSeatNo(@Param("showId") int showId, @Param("seatNo") int seatNo);

	// To get the show from the booking id , To check whether show is started or not
	@Query("SELECT b.show FROM Cinema b WHERE b.bookingId = :bookingId AND b.customerId=:customerId")
	public Showss getShow(@Param("bookingId") int bookingId, @Param("customerId") String customerId);

	@Modifying
	@Query("DELETE FROM Cinema b  WHERE b.bookingId = :bookingId AND b.customerId=:customerId ")
	void deleteByIdAndCustomerId(@Param("bookingId") int bookingId, @Param("customerId") String customerId);

	@Query("SELECT b FROM Cinema b WHERE b.customerId = :customerId")
	public List<Cinema> findByCustomerId(String customerId);
}
