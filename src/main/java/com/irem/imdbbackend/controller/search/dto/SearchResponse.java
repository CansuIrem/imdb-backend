package com.irem.imdbbackend.controller.search.dto;

import com.irem.imdbbackend.service.dto.CastPersonResponse;
import com.irem.imdbbackend.service.dto.MovieResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SearchResponse {

    private List<CastPersonResponse> people;
    private List<MovieResponse> movies;
}
