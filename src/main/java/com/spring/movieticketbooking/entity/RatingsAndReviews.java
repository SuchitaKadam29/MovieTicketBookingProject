package com.spring.movieticketbooking.entity;

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
public class RatingsAndReviews {

	@Id
	@Column(name="rating_id")
	private int ratingId;
	
	@Column(name="customer_id")
	private String customerId;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Moviess movie;
	
	@Column(name="rating")
	private	Double rating;
	
	@Column(name="review")
	private String review;
    

}
