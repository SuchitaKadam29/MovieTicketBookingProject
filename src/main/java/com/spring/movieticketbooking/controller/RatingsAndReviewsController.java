package com.spring.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movieticketbooking.dto.RatingsAndReviewsDTO;
import com.spring.movieticketbooking.entity.RatingsAndReviews;
import com.spring.movieticketbooking.exception.MovieException;
import com.spring.movieticketbooking.service.IRatingsAndReviewsService;


/*
 * Author - Suchita Kadam
 * 12 April 2023
 * 
 */
@RestController
@RequestMapping("/movies")
public class RatingsAndReviewsController {

	@Autowired
	IRatingsAndReviewsService ratingsAndReviewsService;

	@PostMapping("/ratemovie")
	public RatingsAndReviews rateMovie(@RequestBody RatingsAndReviewsDTO ratingsAndReviewsDTO) throws MovieException {
		return ratingsAndReviewsService.addRatingsAndReviews(ratingsAndReviewsDTO);
	}

	@GetMapping("/getmovieratings/{movieName}")
	public List<RatingsAndReviews> getRatingsByMovie(@PathVariable String movieName) {
		return ratingsAndReviewsService.getRatingsBymovieName(movieName);
	}
}
