package com.irem.imdbbackend.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

import static com.irem.imdbbackend.core.helper.DateTimeHelper.getDateTimeNow;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(uniqueConstraints =
    @UniqueConstraint(columnNames = {"email"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    @Size(min = 2)
    private String surname;

    @NotNull
    private String email;

    @NotNull
    @Size(min = 8)
    private String password;

    @NotNull
    private String country;

    @NotNull
    private String city;

    private BigInteger signUpDate;

    @PrePersist
    private void beforeInsert() {
        signUpDate = getDateTimeNow();
    }
}
