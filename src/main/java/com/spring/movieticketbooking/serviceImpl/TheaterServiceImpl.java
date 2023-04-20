package com.spring.movieticketbooking.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.movieticketbooking.entity.Theaterss;
import com.spring.movieticketbooking.repo.TheaterRepository;
import com.spring.movieticketbooking.service.ITheaterService;

/*
 * Author - Suchita Kadam
 * 12 April 2023
 * 
 */
@Service
public class TheaterServiceImpl implements ITheaterService {

	@Autowired
	TheaterRepository theaterRepo;

	@Override
	public List<Theaterss> getTheater() {
		return theaterRepo.findAll();
	}

	@Override
	public List<Theaterss> searchTheaterByKeyword(String keyword) {
		return theaterRepo.searchTheaterByKeyword(keyword.toLowerCase());
	}

	

}
