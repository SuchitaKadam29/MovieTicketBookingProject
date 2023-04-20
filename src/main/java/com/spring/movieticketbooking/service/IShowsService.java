package com.spring.movieticketbooking.service;

import java.util.List;

import com.spring.movieticketbooking.entity.Shows;

/*
 * Author - Suchita Kadam
 * 9 April 2023
 * 
 */
public interface IShowsService {
	
	
public List<Shows> getShows();
	
	public List<Shows> searchShowsByTitle(String movieTitle);

}
