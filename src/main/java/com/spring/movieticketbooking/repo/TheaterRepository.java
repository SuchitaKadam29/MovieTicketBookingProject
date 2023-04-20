package com.spring.movieticketbooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.movieticketbooking.entity.Theater;



/*
 * Author - Suchita Kadam
 * 8 April 2023
 * 
 */
@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {


	@Query("SELECT t FROM Theater t  WHERE LOWER(t.theaterName) like %:key% OR UPPER(t.location) like %:key%")
	public List<Theater> searchTheaterByKeyword(@Param("key")String keyword);
	
	@Query("SELECT t.seatingCapacity FROM Theater t  WHERE t.theaterId = :theaterId")
	public Long getTotalCapacity(@Param("theaterId")int theaterId);

}