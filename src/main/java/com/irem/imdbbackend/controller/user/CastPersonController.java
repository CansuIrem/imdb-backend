package com.irem.imdbbackend.controller.user;

import com.irem.imdbbackend.controller.BaseResponse;
import com.irem.imdbbackend.service.castperson.CastPersonService;
import com.irem.imdbbackend.service.dto.CastPersonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/cast")
public class CastPersonController {

    private final CastPersonService castPersonService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<BaseResponse<List<CastPersonResponse>>> getAllCastPersons() {
        List<CastPersonResponse> responseList = castPersonService.getAll();

        if (responseList.isEmpty())
            return new ResponseEntity<>(new BaseResponse<>(Boolean.FALSE, "There is no person.", null), HttpStatus.OK);
        return new ResponseEntity<>(new BaseResponse<>(Boolean.TRUE, "Operation successful.", responseList), HttpStatus.OK);
    }
}
