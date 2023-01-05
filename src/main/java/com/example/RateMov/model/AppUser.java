package com.example.RateMov.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "last_name")
    @JsonIgnore
    private String lastName;
    @Column(name = "first_name")
    @JsonIgnore
    private String firstName;
    @Column(name = "password")
    @JsonIgnore
    private String password;
    @Column(name = "email")
    @JsonIgnore
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Review> reviews= new ArrayList<>();

}
