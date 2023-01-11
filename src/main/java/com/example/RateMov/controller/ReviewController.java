package com.example.RateMov.controller;

import com.example.RateMov.Exception.UserDoesNotExistException;
import com.example.RateMov.model.Review;
import com.example.RateMov.request.AddReviewRequest;
import com.example.RateMov.response.BaseResponse;
import com.example.RateMov.response.ListResponse;
import com.example.RateMov.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/movie/{movie_id}")
    public ResponseEntity<ListResponse> getReviewsByMovieId(@PathVariable("movie_id") String id){
        List<Review> reviews = reviewService.findReviewByMovieid(id);
        ListResponse response = new ListResponse();
        response.setSuccessful(true);
        response.setReviews(reviews);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("/add")
    public ResponseEntity<BaseResponse> addReviews(@RequestBody AddReviewRequest request){
        try {
            reviewService.addReview(request);
            BaseResponse response = new BaseResponse();
            response.setSuccessful(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (UserDoesNotExistException e) {
            BaseResponse response = new BaseResponse();
            response.setSuccessful(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
