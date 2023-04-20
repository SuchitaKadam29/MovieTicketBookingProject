package com.spring.movieticketbooking.dto;


import java.sql.Date;
import java.sql.Time;

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
public class ShowsDTO {

	private int showId;
	private Date showDate;
	private Time showTime;
	private int availableSeats;

}
