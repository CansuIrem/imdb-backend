package com.irem.imdbbackend.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BaseResponse<T> {
    private Boolean result;
    private String description;
    private T data;
}
