package com.example.demo.controller;

import com.example.demo.entityone.FirstEntity;
import com.example.demo.entityone.Table1;
import com.example.demo.service.Table1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Table1Controller {

    @Autowired
    private Table1Service table1Service;

    @GetMapping("/tableones")
    public ResponseEntity<List<Table1>> getAllTableOne(){
        return new ResponseEntity<>(table1Service.getAll(), HttpStatus.OK);
    }
}
