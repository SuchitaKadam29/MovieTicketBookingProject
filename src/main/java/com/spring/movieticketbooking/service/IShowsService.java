package com.spring.movieticketbooking.service;

import java.util.List;

import com.spring.movieticketbooking.entity.Showss;

/*
 * Author - Suchita Kadam
 * 9 April 2023
 * 
 */
public interface IShowsService {
	
	
public List<Showss> getShows();
	
	public List<Showss> searchShowsByTitle(String movieTitle);

}
