package com.irem.imdbbackend.core.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseConstants {

    SUCCESSFUL("success"),
    FAILED("fail");

    private final String result;
}
