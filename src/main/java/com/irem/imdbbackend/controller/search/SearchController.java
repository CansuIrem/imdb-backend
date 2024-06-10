package com.irem.imdbbackend.controller.search;

import com.irem.imdbbackend.controller.search.dto.SearchResponse;
import com.irem.imdbbackend.service.castperson.CastPersonService;
import com.irem.imdbbackend.service.dto.CastPersonResponse;
import com.irem.imdbbackend.service.dto.MovieResponse;
import com.irem.imdbbackend.service.movie.MovieService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SearchController {

    private final CastPersonService castPersonService;

    private final MovieService movieService;

    @CrossOrigin
    @GetMapping("/search/{keyword}")
    public ResponseEntity<SearchResponse> search(@PathVariable(name = "keyword") String keyword) {
        List<CastPersonResponse> castPersonResponses = castPersonService.search(keyword);
        List<MovieResponse> movieResponses = movieService.search(keyword);

        if (castPersonResponses.isEmpty() && movieResponses.isEmpty())
            return new ResponseEntity<>(SearchResponse.builder().build(), HttpStatus.OK);
        return new ResponseEntity<>(SearchResponse
                .builder()
                .people(castPersonResponses)
                .movies(movieResponses)
                .build(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/movies")
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        List<MovieResponse> responseList = movieService.getAll();

        if (responseList.isEmpty())
            return new ResponseEntity<>(List.of(MovieResponse.builder().build()), HttpStatus.OK);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
