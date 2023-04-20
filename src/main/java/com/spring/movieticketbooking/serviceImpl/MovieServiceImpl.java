package com.spring.movieticketbooking.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.movieticketbooking.entity.Movie;
import com.spring.movieticketbooking.repo.MovieRepository;
import com.spring.movieticketbooking.service.IMovieService;

/*
 * Author - Suchita Kadam
 * 13 April 2023
 * 
 */
@Service
public class MovieServiceImpl implements IMovieService {

	@Autowired
	MovieRepository movieRepo;

	@Override
	public List<Movie> getMovies() {
		return movieRepo.findAll();
	}

	@Override
	public List<Movie> searchMovieByKeyword(String keyword) {
		return movieRepo.searchMoviesByKeyword(keyword.toLowerCase());
	}

}

