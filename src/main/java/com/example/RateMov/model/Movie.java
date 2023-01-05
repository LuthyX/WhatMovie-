package com.example.RateMov.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbid;
    private Long id;
    private String original_title;
    @Column(length = 65555)
    private String overview;
    private String budget;
    private String release_date;
    private String runtime;
    private String status;
    private String vote_count;
    private String comment;
    @OneToMany(mappedBy = "movie")
    private List<Review> reviews = new ArrayList<>();
}
