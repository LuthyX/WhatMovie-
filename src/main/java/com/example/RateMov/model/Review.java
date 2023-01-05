package com.example.RateMov.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", referencedColumnName = "dbid")
    @JsonIgnore
    private Movie movie;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "app_user_id", referencedColumnName = "id")
    private AppUser user;
    private String comment;
}
