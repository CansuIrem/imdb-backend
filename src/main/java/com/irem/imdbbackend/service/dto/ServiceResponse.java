package com.irem.imdbbackend.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ServiceResponse {
    private Boolean result;
    private String description;
}
