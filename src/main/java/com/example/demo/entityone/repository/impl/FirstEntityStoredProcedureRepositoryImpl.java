package com.example.demo.entityone.repository.impl;

import com.example.demo.entityone.repository.FirstEntityStoredProcedureRepository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

public class FirstEntityStoredProcedureRepositoryImpl implements FirstEntityStoredProcedureRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Long countFirstEntityById(Long id) {
        StoredProcedureQuery countAllProcedure = em.createNamedStoredProcedureQuery("countAllStoredProd")
            .registerStoredProcedureParameter(
                1,
                Long.class,
                ParameterMode.IN
            )
            .registerStoredProcedureParameter(
                2,
                Long.class,
                ParameterMode.OUT
            )
            .setParameter(1, id);
        countAllProcedure.execute();

        return (Long) countAllProcedure.getOutputParameterValue(2);
    }
}
