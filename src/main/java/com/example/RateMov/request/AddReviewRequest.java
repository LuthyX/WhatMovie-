package com.example.RateMov.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddReviewRequest {
    private String username;
    private String movie_id;
    private String comment;
}
