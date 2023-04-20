package com.spring.movieticketbooking.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter   
@Data
@Entity
@Table(name="Cinema")
public class Cinema {
	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	
	@Column(name="customer_id")
	private String customerId;
	
	@ManyToOne
	@JoinColumn(name = "show_id")
	 private Showss show;
	
	@Column(name="booking_date")
	private Date bookingDate;
	
	@Column(name="total_amount")
	private Double totalAmount;
	
	@Column(name="payment_method")
	private	String paymentMethod;
	
	@Column(name="seat_no")
	private	int seatNo;

}