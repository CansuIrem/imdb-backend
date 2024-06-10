package com.irem.imdbbackend.data.repository;

import com.irem.imdbbackend.data.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String keyword1, String keyword2);
}
