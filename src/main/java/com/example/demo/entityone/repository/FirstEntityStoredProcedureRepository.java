package com.example.demo.entityone.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface FirstEntityStoredProcedureRepository {

    Long countFirstEntityById(Long id);
}
