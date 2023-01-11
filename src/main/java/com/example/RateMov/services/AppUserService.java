package com.example.RateMov.services;

import com.example.RateMov.Exception.PasswordInvalidException;
import com.example.RateMov.Exception.UserAlreadyExistsException;
import com.example.RateMov.model.AppUser;
import com.example.RateMov.repository.AppUserRepository;
import com.example.RateMov.request.LoginBody;
import com.example.RateMov.request.RegistrationBody;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AppUserService {
    private AppUserRepository appUserRepository;
    private EncryptionService encryptionService;
    private JWTService jwtService;
//    private EmailService emailService;
//    private VerificationTokenRepostiory verificationTokenRepostiory;
//    private PasswordResetTokenRepository passwordResetTokenRepository;

    public AppUserService(AppUserRepository appUserRepository, EncryptionService encryptionService, JWTService jwtService){
        this.appUserRepository = appUserRepository;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;

//        this.verificationTokenRepostiory = verificationTokenRepostiory;
//        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }

    public AppUser registerUser (RegistrationBody registrationBody) throws UserAlreadyExistsException{

        if (appUserRepository.findByUsername(registrationBody.getUsername()).isPresent()
                || appUserRepository.findByEmail(registrationBody.getEmail()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        AppUser appUser = new AppUser();
        appUser.setUsername(registrationBody.getUsername());
        appUser.setLastName(registrationBody.getLastName());
        appUser.setFirstName(registrationBody.getFirstName());
        appUser.setEmail(registrationBody.getEmail());
        appUser.setCreateTime(LocalDateTime.now());
        appUser.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        return appUserRepository.save(appUser);
    }

    public String loginUser(@RequestBody LoginBody loginBody) throws PasswordInvalidException {
        Optional<AppUser> optionalAppUser = appUserRepository.findByUsername(loginBody.getUsername());
        if (optionalAppUser.isPresent()){
            AppUser user = optionalAppUser.get();
            if (encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {
                return jwtService.generateJWT(user);
            }
            else {
                throw new PasswordInvalidException();
            }
        }
        return null;
    }
}
