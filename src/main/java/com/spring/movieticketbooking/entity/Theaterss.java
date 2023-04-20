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
@Table(name="Theaterss")
public class Theaterss {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="theater_id")
	 int theaterId;
	 @Column(name="theater_name")
	 String theaterName;
	 @Column(name="location")
	 String location;
	 @Column(name="seating_capacity")
	 int seatingCapacity;
	 @Column(name="ticket_price")
	 double ticketPrice;
   

}