package com.irem.imdbbackend.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CastPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String birthDate;

    private String gender;

    private String description;

    private String photo;

    @OneToMany(mappedBy = "castPerson")
    private List<CastPersonMovie> castPersonMovies = new ArrayList<>();
}
