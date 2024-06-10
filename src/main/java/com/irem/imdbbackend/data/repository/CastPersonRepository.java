package com.irem.imdbbackend.data.repository;

import com.irem.imdbbackend.data.entity.CastPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CastPersonRepository extends JpaRepository<CastPerson, Long> {

    List<CastPerson> findAllByNameContainsIgnoreCase(String keyword);
}
