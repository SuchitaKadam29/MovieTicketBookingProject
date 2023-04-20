package com.spring.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movieticketbooking.entity.Theater;
import com.spring.movieticketbooking.service.ITheaterService;



/*
 * Author - Suchita Kadam
 * 13 April 2023
 * 
 */
@RestController
@RequestMapping("/movies")
public class TheatersController {
	
	

		@Autowired
		ITheaterService theaterService;
		
		@GetMapping("/searchTheater/{keyword}")
		public List<Theater> searchTheater(@PathVariable String keyword) {
			return theaterService.searchTheaterByKeyword(keyword);
		}
		
	}
