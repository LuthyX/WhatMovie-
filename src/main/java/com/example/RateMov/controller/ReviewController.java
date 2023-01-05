package com.example.RateMov.controller;

import com.example.RateMov.request.AddReviewRequest;
import com.example.RateMov.response.BaseResponse;
import com.example.RateMov.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private MovieService movieService;

    public ReviewController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> addReview(@RequestBody AddReviewRequest request){
        movieService.addReview(request);
        BaseResponse response = new BaseResponse();
        response.setSuccessful(true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
