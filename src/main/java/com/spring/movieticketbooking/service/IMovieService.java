package com.spring.movieticketbooking.service;

import java.util.List;

import com.spring.movieticketbooking.entity.Movie;

/*
 * Author - Suchita Kadam
 * 9 April 2023
 * 
 */
public interface IMovieService {
	public List<Movie> getMovies();

	public List<Movie> searchMovieByKeyword(String keyword);

}
