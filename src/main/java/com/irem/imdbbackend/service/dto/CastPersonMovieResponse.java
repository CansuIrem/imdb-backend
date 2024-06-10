package com.irem.imdbbackend.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CastPersonMovieResponse {

    private String movie;

    private String position;
}
