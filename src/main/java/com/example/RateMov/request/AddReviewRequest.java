package com.example.RateMov.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddReviewRequest {
    private Long app_user_id;
    private String movie_id;
    private String comment;
}
