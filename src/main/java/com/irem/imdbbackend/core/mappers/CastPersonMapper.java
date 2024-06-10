package com.irem.imdbbackend.core.mappers;

import com.irem.imdbbackend.data.entity.CastPerson;
import com.irem.imdbbackend.service.dto.CastPersonResponse;

import java.util.ArrayList;
import java.util.List;

public class CastPersonMapper {

    public static CastPersonResponse map(CastPerson castPerson) {
        CastPersonResponse response = new CastPersonResponse();
        if (castPerson != null) {
            response.setName(castPerson.getName());
            response.setGender(castPerson.getGender());
            response.setBirthDate(castPerson.getBirthDate());
            response.setDescription(castPerson.getDescription());
            response.setPhoto(castPerson.getPhoto());
            response.setCastPersonMovies(CastPersonMovieMapper.map(castPerson.getCastPersonMovies()));
        }

        return response;
    }

    public static List<CastPersonResponse> map (List<CastPerson> castPersonList) {
        if (castPersonList.isEmpty())
            return new ArrayList<>();
        List<CastPersonResponse> responseList = new ArrayList<>();

        for (CastPerson castPerson : castPersonList)
            responseList.add(map(castPerson));

        return responseList;
    }
}
