package com.spring.movieticketbooking.service;

import java.util.List;

import com.spring.movieticketbooking.entity.Theaterss;

/*
 * Author - Suchita Kadam
 * 9 April 2023
 * 
 */
public interface ITheaterService {

	
public List<Theaterss> getTheater();
	
	public List<Theaterss>searchTheaterByKeyword(String keyword);

}
