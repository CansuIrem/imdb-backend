package com.irem.imdbbackend.service.castperson;

import com.irem.imdbbackend.data.entity.CastPerson;
import com.irem.imdbbackend.data.repository.CastPersonRepository;
import com.irem.imdbbackend.service.dto.CastPersonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.irem.imdbbackend.core.mappers.CastPersonMapper.map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CastPersonServiceImpl implements CastPersonService{

    private final CastPersonRepository castPersonRepository;
    @Override
    public List<CastPersonResponse> getAll() {

        List<CastPerson> castPersonList = castPersonRepository.findAll();

        if (castPersonList.isEmpty()) {
            log.info("There is no person.");
            return new ArrayList<>();
        }

        return map(castPersonList);
    }

    @Override
    public List<CastPersonResponse> search(String keyword) {
        List<CastPerson> castPersonList = castPersonRepository.findAllByNameContainsIgnoreCase(keyword);

        if (castPersonList.isEmpty()) {
            log.info("There is no person.");
            return new ArrayList<>();
        }

        return map(castPersonList);
    }
}
