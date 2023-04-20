package com.spring.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movieticketbooking.entity.Showss;
import com.spring.movieticketbooking.service.IShowsService;


/*
 * Author - Suchita Kadam
 * 13 April 2023
 * 
 */
@RestController
@RequestMapping("/movies")
public class ShowsController {
	

	@Autowired
	IShowsService showService;
	
	@GetMapping("/getshows/{keyword}")
	public List<Showss> getShowsByMovies(@PathVariable String keyword) {
		return showService.searchShowsByTitle(keyword);
	}
	

}
