//package com.example.RateMov.model;
//
//import jakarta.persistence.Entity;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Movies {
//
//    @Value("${api.key}")
//    private String apiKey;
//
//    String url = "https://api.themoviedb.org/3/movie/?api_key="+ apiKey ;
//
//    RestTemplate res = new RestTemplate();
//
//    private Long id;
//    private String movieId;
//    private String movieTitle;
//    private String movieDescription;
//    private String movieImgUrl;
//    private String movieRating;
//    private String movieReleaseDate;
//
//    private List<Review> reviews = new ArrayList<>();
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getMovieId() {
//        return movieId;
//    }
//
//    public void setMovieId(String movieId) {
//        this.movieId = movieId;
//    }
//
//    public String getMovieTitle() {
//        return movieTitle;
//    }
//
//    public void setMovieTitle(String movieTitle) {
//        this.movieTitle = movieTitle;
//    }
//
//    public String getMovieDescription() {
//        return movieDescription;
//    }
//
//    public void setMovieDescription(String movieDescription) {
//        this.movieDescription = movieDescription;
//    }
//
//    public String getMovieImgUrl() {
//        return movieImgUrl;
//    }
//
//    public void setMovieImgUrl(String movieImgUrl) {
//        this.movieImgUrl = movieImgUrl;
//    }
//
//    public String getMovieRating() {
//        return movieRating;
//    }
//
//    public void setMovieRating(String movieRating) {
//        this.movieRating = movieRating;
//    }
//
//    public String getMovieReleaseDate() {
//        return movieReleaseDate;
//    }
//
//    public void setMovieReleaseDate(String movieReleaseDate) {
//        this.movieReleaseDate = movieReleaseDate;
//    }
//
//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }
//}
