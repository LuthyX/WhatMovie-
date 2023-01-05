package com.example.RateMov.services;

import com.example.RateMov.model.AppUser;
import com.example.RateMov.model.Movie;
import com.example.RateMov.model.Review;
import com.example.RateMov.repository.AppUserRepository;
import com.example.RateMov.repository.MovieRepository;
import com.example.RateMov.repository.ReviewRepository;
import com.example.RateMov.request.AddReviewRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service
public class MovieService {


    @Value("${api.key}")
    private static String api_key;
    private static String url = "https://api.themoviedb.org/3/movie/550?api_key=" + api_key;

    private MovieRepository movieRepository;
    private ReviewRepository reviewRepository;
    private AppUserRepository appUserRepository;
    RestTemplate restTemplate = new RestTemplate();

    public MovieService(MovieRepository movieRepository, ReviewRepository reviewRepository, AppUserRepository appUserRepository) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
        this.appUserRepository = appUserRepository;
    }

    public Movie movieTest(){
        Movie movie = restTemplate.getForObject(url, Movie.class);
        log.info(String.valueOf(movie.getId()));
        if(movieRepository.findById(movie.getId()).isPresent()){
            Optional<Movie> usMovie = movieRepository.findById(movie.getId());
            Movie movie1 = usMovie.get();
            log.info("from if- " + movie1.getId());
            return movie1;
        }
        else{
            movieRepository.save(movie);
            return movie;
        }

    }

    public void addReview(AddReviewRequest request){
        Review review = new Review();
        AppUser appUser = appUserRepository.findById(request.getApp_user_id()).orElseThrow(IllegalStateException::new);
        Movie movie = movieRepository.findByDbid(request.getMovie_id()).orElseThrow(IllegalStateException::new);
        review.setMovie(movie);
        review.setUser(appUser);
        review.setComment(request.getComment());
        reviewRepository.save(review);
    }
}
