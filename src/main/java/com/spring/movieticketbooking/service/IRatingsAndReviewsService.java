package com.spring.movieticketbooking.service;

import java.util.List;

import com.spring.movieticketbooking.dto.RatingsAndReviewsDTO;
import com.spring.movieticketbooking.entity.RatingsAndReviews;
import com.spring.movieticketbooking.exception.MovieException;

/*
 * Author - Suchita Kadam
 * 9 April 2023
 * 
 */
public interface IRatingsAndReviewsService {
	


public RatingsAndReviews addRatingsAndReviews(RatingsAndReviewsDTO ratingsDTO) throws MovieException;
	
	public List<RatingsAndReviews> getRatingsBymovieName(String moviename);



}