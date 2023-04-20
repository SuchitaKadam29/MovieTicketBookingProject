package com.spring.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movieticketbooking.entity.Movie;
import com.spring.movieticketbooking.service.IMovieService;


/*
 * Author - Suchita Kadam
 * 12 April 2023
 * 
 */
@RestController
@RequestMapping("/movies")
public class MoviesController {

	@Autowired
	IMovieService movieServies;

	@GetMapping("/searchmovie/{keyword}")
	public List<Movie> searchMovies(@PathVariable String keyword) {

		return movieServies.searchMovieByKeyword(keyword);
	}

}
