package com.spring.movieticketbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * Author - Suchita Kadam
 * 6 April 2023
 * 
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TheaterDTO {
	
	private	int theaterId;
	private String theaterName;
	private	String location;
	private int seatingCapacity;

}