package com.spring.movieticketbooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.movieticketbooking.entity.Moviess;

/*
 * Author - Suchita Kadam
 * 8 April 2023
 * 
 */
@Repository
public interface MovieRepository extends JpaRepository<Moviess, Integer> {

	@Query("SELECT m FROM Moviess m WHERE LOWER(m.genre) like %:key% OR LOWER(m.movieTitle) like %:key%")
	public List<Moviess> searchMoviesByKeyword(@Param("key") String keyword);

}
