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
public class RatingsAndReviewsDTO {

	private int movieId;
	private Double rating;
	private String review;

}
