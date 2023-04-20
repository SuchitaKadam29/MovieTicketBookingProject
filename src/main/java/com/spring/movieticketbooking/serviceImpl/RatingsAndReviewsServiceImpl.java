package com.spring.movieticketbooking.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.spring.movieticketbooking.dto.RatingsAndReviewsDTO;
import com.spring.movieticketbooking.entity.Movie;
import com.spring.movieticketbooking.entity.RatingsAndReviews;
import com.spring.movieticketbooking.exception.MovieException;
import com.spring.movieticketbooking.repo.MovieRepository;
import com.spring.movieticketbooking.repo.RatingsAndReviewsRepository;
import com.spring.movieticketbooking.service.IRatingsAndReviewsService;

import lombok.extern.log4j.Log4j2;


/*
 * Author - Suchita Kadam
 * 12 April 2023
 * 
 */
@Log4j2
@Service
public class RatingsAndReviewsServiceImpl implements IRatingsAndReviewsService {

	@Autowired
	RatingsAndReviewsRepository ratingsAndReviewsRepo;

	@Autowired
	MovieRepository movieRepo;

	@Override
	public RatingsAndReviews addRatingsAndReviews(RatingsAndReviewsDTO ratingsAndReviewsDTO) throws MovieException {

				Movie movie = movieRepo.findById(ratingsAndReviewsDTO.getMovieId()).orElse(null);
				Double userRating = ratingsAndReviewsDTO.getRating();
				if (movie != null) {

					if (userRating >= 1 && userRating <= 5) {

						RatingsAndReviews ratings = new RatingsAndReviews();
						String customerId = SecurityContextHolder.getContext().getAuthentication().getName();
						ratings.setRating(userRating);
						ratings.setReview(ratingsAndReviewsDTO.getReview());
						ratings.setMovie(movie);
						ratings.setCustomerId(customerId);
						ratings = ratingsAndReviewsRepo.save(ratings);
						
						Double totalRating=ratingsAndReviewsRepo.getTotalRatingByMovie(movie.getMovieTitle());
						movie.setRating(totalRating);
						movieRepo.save(movie);
						
						return ratings;
					}else {
						log.error("Rating should be between 1 and 5");
						throw (new MovieException("Rating should be between 1 and 5"));
						
					}

				} else {

					log.error("Cannot find the movie");
					throw (new MovieException("Cannot find the movie"));
					
				}
			}

	@Override
	public List<RatingsAndReviews> getRatingsBymovieName(String moviename) {
		// TODO Auto-generated method stub
		return ratingsAndReviewsRepo.findRatingsByMovieTitle(moviename);
	}

}
