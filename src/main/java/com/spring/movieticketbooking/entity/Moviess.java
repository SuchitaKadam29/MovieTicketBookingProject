package com.spring.movieticketbooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Author - Suchita Kadam
 * 6 April 2023
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name="moviess")
public class Moviess {
	@Id
	@Column(name = "movie_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	@Column(name = "movie_title")
	private String movieTitle;
	private String genre;
	private String director;
	private int duration;
	private double rating;

}