package com.example.demo.service;

import com.example.demo.entityone.FirstEntity;
import com.example.demo.entityone.repository.FirstEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FirstEntityService {

    @Autowired
    private FirstEntityRepository firstEntityRepository;

    @Transactional(transactionManager="firstDataSourceTransactionManager")
    public List<FirstEntity> getAll()
    {
        return firstEntityRepository.findAll();
    }

    @Transactional(transactionManager="firstDataSourceTransactionManager")
    public Long countAllStoredProd(Long id)
    {
        return firstEntityRepository.countFirstEntityById(id);
    }
}
