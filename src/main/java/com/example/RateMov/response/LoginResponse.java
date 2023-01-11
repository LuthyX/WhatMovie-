package com.example.RateMov.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String Jwt;
    private String Username;
    private Boolean success;
    private String failureReason;
}
