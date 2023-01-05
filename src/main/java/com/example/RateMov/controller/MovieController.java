package com.example.RateMov.controller;

import com.example.RateMov.model.Movie;
import com.example.RateMov.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Movie> getMovie(){
        return ResponseEntity.ok(movieService.movieTest());
    }
}
