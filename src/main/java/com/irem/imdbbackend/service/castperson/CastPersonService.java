package com.irem.imdbbackend.service.castperson;

import com.irem.imdbbackend.service.dto.CastPersonResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CastPersonService {
    List<CastPersonResponse> getAll();
    List<CastPersonResponse> search(String keyword);
}
