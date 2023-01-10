package com.example.RateMov.response;

import com.example.RateMov.model.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResponse {
    private  Boolean successful;
    private String failureReason = null;

    private List<Review> reviews;
}
