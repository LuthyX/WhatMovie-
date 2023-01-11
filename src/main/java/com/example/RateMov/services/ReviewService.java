package com.example.RateMov.services;

import com.example.RateMov.Exception.UserDoesNotExistException;
import com.example.RateMov.model.AppUser;
import com.example.RateMov.model.Review;
import com.example.RateMov.repository.AppUserRepository;
import com.example.RateMov.repository.ReviewRepository;
import com.example.RateMov.request.AddReviewRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;
    private AppUserRepository appUserRepository;

    public ReviewService(ReviewRepository reviewRepository, AppUserRepository appUserRepository) {
        this.reviewRepository = reviewRepository;
        this.appUserRepository = appUserRepository;
    }

    public List<Review> findReviewByMovieid(String movieId){
        List <Review> reviews = reviewRepository.findByMovieId(movieId);
        return reviews;
    }
    public void addReview(AddReviewRequest request) throws UserDoesNotExistException {
        Optional<AppUser> optApp = appUserRepository.findByUsername(request.getUsername());
        if(!optApp.isPresent()){
            throw new UserDoesNotExistException();
        }
        AppUser appUser = optApp.get();
        Review review = new Review();
        review.setUser(appUser);
        review.setComment(request.getComment());
        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");;
        String formattedString = LocalDateTime.now().format(customFormat);
        review.setCreated_at(formattedString);
        review.setMovie_id(request.getMovie_id());
        reviewRepository.save(review);
    }
}
