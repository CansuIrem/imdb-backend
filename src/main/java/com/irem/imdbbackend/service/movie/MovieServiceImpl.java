package com.irem.imdbbackend.service.movie;

import com.irem.imdbbackend.data.entity.Movie;
import com.irem.imdbbackend.data.repository.MovieRepository;
import com.irem.imdbbackend.service.dto.MovieResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.irem.imdbbackend.core.mappers.MovieMapper.map;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<MovieResponse> getAll() {
        List<Movie> movieList = movieRepository.findAll();

        if (movieList.isEmpty()) {
            log.info("There is no movies.");
            return new ArrayList<>();
        }

        return map(movieList);
    }

    @Override
    public List<MovieResponse> search(String keyword) {

        List<Movie> movieList = movieRepository.findAllByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(keyword, keyword);

        if (movieList.isEmpty()) {
            log.info("There is no movies.");
            return new ArrayList<>();
        }

        return map(movieList);
    }
}
