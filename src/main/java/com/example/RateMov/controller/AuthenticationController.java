package com.example.RateMov.controller;

import com.example.RateMov.Exception.PasswordInvalidException;
import com.example.RateMov.Exception.UserAlreadyExistsException;
import com.example.RateMov.request.LoginBody;
import com.example.RateMov.request.RegistrationBody;
import com.example.RateMov.response.LoginResponse;
import com.example.RateMov.services.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin()
public class AuthenticationController {

    private AppUserService appUserService;
    public AuthenticationController(AppUserService appUserService){
        this.appUserService = appUserService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody RegistrationBody registrationBody){
        try{appUserService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        }
        catch (UserAlreadyExistsException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginBody loginBody){
        String jwt = null;
        try {
            jwt = appUserService.loginUser(loginBody);
        } catch (PasswordInvalidException e) {
            LoginResponse response = new LoginResponse();
            response.setSuccess(false);
            response.setFailureReason("Password is Invalid");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        if (jwt == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);
            response.setUsername(loginBody.getUsername());
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        }
    }

}
