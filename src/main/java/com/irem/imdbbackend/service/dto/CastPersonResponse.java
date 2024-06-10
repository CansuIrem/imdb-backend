package com.irem.imdbbackend.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CastPersonResponse {

    private String name;

    private String birthDate;

    private String gender;

    private String description;

    private String photo;

    private List<CastPersonMovieResponse> castPersonMovies;
}
