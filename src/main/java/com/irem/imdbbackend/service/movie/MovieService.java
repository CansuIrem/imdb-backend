package com.irem.imdbbackend.service.movie;


import com.irem.imdbbackend.service.dto.MovieResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<MovieResponse> getAll();
    List<MovieResponse> search(String keyword);
}
