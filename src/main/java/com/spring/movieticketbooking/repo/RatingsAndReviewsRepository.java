package com.spring.movieticketbooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.movieticketbooking.entity.RatingsAndReviews;

/*
 * Author - Suchita Kadam
 * 8 April 2023
 * 
 */
@Repository
public interface RatingsAndReviewsRepository extends JpaRepository<RatingsAndReviews, Integer>  {
	


	@Query("SELECT r FROM RatingsAndReviews r WHERE LOWER(r.movie.movieTitle) like %:title%")
	public List<RatingsAndReviews> findRatingsByMovieTitle(@Param("title") String movieName);

	@Query("SELECT AVG(r.rating) FROM RatingsAndReviews r WHERE r.movie.movieTitle like %:title%")
	public Double getTotalRatingByMovie(@Param("title") String movieName);

}
