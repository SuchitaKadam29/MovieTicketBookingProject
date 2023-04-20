package com.spring.movieticketbooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.movieticketbooking.entity.Showss;

/*
 * Author - Suchita Kadam
 * 8 April 2023
 * 
 */
@Repository
public interface ShowsRepository extends JpaRepository<Showss, Integer> {
	

	@Query("SELECT s FROM Showss s WHERE LOWER(s.movie.movieTitle) like %:movieTitle%")
	public List<Showss> searchShowsByTitle(@Param("movieTitle")String movieTitle);


}
