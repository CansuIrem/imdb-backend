package com.irem.imdbbackend.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private double duration;

    private double rating;

    private Integer popularity;

    @NotNull
    private Integer releaseDate;

    private String photo;

    private String trailer;

    @OneToMany(mappedBy = "movie")
    private List<CastPersonMovie> castPersonMovies = new ArrayList<>();
}
