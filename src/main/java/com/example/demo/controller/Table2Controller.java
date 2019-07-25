package com.example.demo.controller;

import com.example.demo.entityone.Table2;
import com.example.demo.service.Table2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Table2Controller {

    @Autowired
    private Table2Service table2Service;

    @GetMapping("/tabletwos")
    public ResponseEntity<List<Table2>> getAllTableTwo(){
        return new ResponseEntity<>(table2Service.getAll(), HttpStatus.OK);
    }
}
