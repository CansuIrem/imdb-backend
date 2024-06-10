package com.irem.imdbbackend.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CastPersonMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cast_person_id")
    private CastPerson castPerson;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private String position;
}
