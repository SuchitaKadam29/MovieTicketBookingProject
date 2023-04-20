package com.spring.movieticketbooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.movieticketbooking.entity.Shows;

/*
 * Author - Suchita Kadam
 * 8 April 2023
 * 
 */
@Repository
public interface ShowsRepository extends JpaRepository<Shows, Integer> {
	

	@Query("SELECT s FROM Shows s WHERE LOWER(s.movie.movieTitle) like %:movieTitle%")
	public List<Shows> searchShowsByTitle(@Param("movieTitle")String movieTitle);


}
