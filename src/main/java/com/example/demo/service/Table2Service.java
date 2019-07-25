package com.example.demo.service;

import com.example.demo.entityone.Table1;
import com.example.demo.entityone.Table2;
import com.example.demo.entityone.repository.Table1Repository;
import com.example.demo.entityone.repository.Table2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Table2Service {

    @Autowired
    private Table2Repository table2Repository;

    @Transactional(transactionManager="firstDataSourceTransactionManager")
    public List<Table2> getAll()
    {
        return table2Repository.findAll();
    }
}
