package com.irem.imdbbackend.core.mappers;

import com.irem.imdbbackend.data.entity.CastPersonMovie;
import com.irem.imdbbackend.service.dto.CastPersonMovieResponse;

import java.util.ArrayList;
import java.util.List;

public class CastPersonMovieMapper {

    public static CastPersonMovieResponse map(CastPersonMovie castPersonMovie) {
        CastPersonMovieResponse response = new CastPersonMovieResponse();

        if (castPersonMovie != null) {
            response.setMovie(castPersonMovie.getMovie().getName());
            response.setPosition(castPersonMovie.getPosition());
        }

        return response;
    }

    public static List<CastPersonMovieResponse> map(List<CastPersonMovie> castPersonMovies) {
        if (castPersonMovies.isEmpty())
            return new ArrayList<>();
        List<CastPersonMovieResponse> responseList = new ArrayList<>();

        for (CastPersonMovie castPersonMovie : castPersonMovies)
            responseList.add(map(castPersonMovie));

        return responseList;
    }
}
