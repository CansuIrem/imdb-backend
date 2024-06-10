package com.irem.imdbbackend.core.mappers;

import com.irem.imdbbackend.data.entity.CastPersonMovie;
import com.irem.imdbbackend.data.entity.Movie;
import com.irem.imdbbackend.service.dto.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {

    public static MovieResponse map(Movie movie) {
        MovieResponse response = new MovieResponse();
        if (movie != null) {
            response.setName(movie.getName());
            response.setDescription(movie.getDescription());
            response.setDuration((int) movie.getDuration());
            response.setPopularity(movie.getPopularity());
            response.setRating(movie.getRating());
            response.setReleaseDate(movie.getReleaseDate());
            response.setPhoto(movie.getPhoto());
            response.setTrailer(movie.getTrailer());
            List<String> stars = new ArrayList<>();

            for (CastPersonMovie castPersonMovie : movie.getCastPersonMovies()) {
                if (castPersonMovie.getPosition().equals("starring"))
                    stars.add(castPersonMovie.getCastPerson().getName());
            }

            response.setStars(stars);
        }

        return response;
    }

    public static List<MovieResponse> map(List<Movie> movieList) {
        if (movieList.isEmpty())
            return new ArrayList<>();
        List<MovieResponse> responseList = new ArrayList<>();

        for (Movie movie : movieList)
            responseList.add(map(movie));

        return responseList;
    }
}
