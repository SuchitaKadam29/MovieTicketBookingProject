package com.spring.movieticketbooking.service;

import java.util.List;

import com.spring.movieticketbooking.entity.Theater;

/*
 * Author - Suchita Kadam
 * 9 April 2023
 * 
 */
public interface ITheaterService {

	
public List<Theater> getTheater();
	
	public List<Theater>searchTheaterByKeyword(String keyword);

}
