package com.example.demo.service;

import com.example.demo.entitytwo.SecondEntity;
import com.example.demo.entitytwo.repository.SecondEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SecondEntityService {

    @Autowired
    private SecondEntityRepository secondEntityRepository;

    @Transactional(transactionManager="secondDataSourceTransactionManager")
    public List<SecondEntity> getAll()
    {
        return secondEntityRepository.findAll();
    }
}
