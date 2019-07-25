package com.example.demo.service;

import com.example.demo.entityone.Table1;
import com.example.demo.entityone.repository.Table1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Table1Service {

    @Autowired
    private Table1Repository table1Repository;

    @Transactional(transactionManager="firstDataSourceTransactionManager")
    public List<Table1> getAll()
    {
        return table1Repository.findAll();
    }
}
