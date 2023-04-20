package com.spring.movieticketbooking.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * Author - Suchita Kadam
 * 6 April 2023
 * 
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Entity
@Table(name="showss")
public class Showss {
	

	@Id
	@Column(name = "show_id")
	private	int showId;

	@ManyToOne
	@JoinColumn(name = "theater_id")
	private Theaterss theatre;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Moviess movie;

	@Column(name = "show_date")
	private Date showDate;

	@Column(name = "show_time")
	private Time showTime;

	@Column(name = "available_seats")
	private int availableSeats;



}

