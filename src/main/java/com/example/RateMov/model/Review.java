package com.example.RateMov.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "movie_id")
    private String movie_id;

    private LocalDateTime localDateTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "app_user_id", referencedColumnName = "id")
    private AppUser user;
    private String comment;
}
