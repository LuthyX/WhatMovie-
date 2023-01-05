package com.example.RateMov.repository;

import com.example.RateMov.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


    @Query("SELECT m FROM Movie m WHERE m.id = ?1")
    Optional<Movie> findById(Long id);

    @Query("SELECT m FROM Movie m WHERE m.dbid = ?1")
    Optional<Movie> findByDbid(Long dbid);

}
