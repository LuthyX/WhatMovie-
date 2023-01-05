package com.example.RateMov.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private  Boolean successful;
    private String failureReason = null;
}
