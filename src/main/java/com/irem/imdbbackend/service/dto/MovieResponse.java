package com.irem.imdbbackend.service.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class MovieResponse {

    private String name;
    private String description;
    private Integer duration;
    private Integer popularity;
    private Double rating;
    private Integer releaseDate;
    private String photo;
    private String trailer;
    private List<String> stars;
}
