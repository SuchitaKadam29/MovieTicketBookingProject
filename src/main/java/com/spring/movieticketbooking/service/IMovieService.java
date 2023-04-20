package com.spring.movieticketbooking.service;

import java.util.List;

import com.spring.movieticketbooking.entity.Moviess;

/*
 * Author - Suchita Kadam
 * 9 April 2023
 * 
 */
public interface IMovieService {
	public List<Moviess> getMovies();

	public List<Moviess> searchMovieByKeyword(String keyword);

}
