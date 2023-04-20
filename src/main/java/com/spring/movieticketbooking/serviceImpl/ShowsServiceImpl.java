package com.spring.movieticketbooking.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.movieticketbooking.entity.Showss;
import com.spring.movieticketbooking.repo.ShowsRepository;
import com.spring.movieticketbooking.service.IShowsService;

/*
 * Author - Suchita Kadam
 * 12 April 2023
 * 
 */
@Service
public class ShowsServiceImpl implements IShowsService {

	@Autowired
	ShowsRepository ShowsRepo;

	@Override
	public List<Showss> getShows() {
		// TODO Auto-generated method stub
		return ShowsRepo.findAll();
	}

	@Override
	public List<Showss> searchShowsByTitle(String movieTitle) {
		// TODO Auto-generated method stub
		return ShowsRepo.searchShowsByTitle(movieTitle.toLowerCase());
	}

}
