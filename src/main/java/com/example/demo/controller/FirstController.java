package com.example.demo.controller;

import com.example.demo.entityone.FirstEntity;
import com.example.demo.entitytwo.SecondEntity;
import com.example.demo.service.FirstEntityService;
import com.example.demo.service.SecondEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FirstController {

    @Autowired
    private FirstEntityService firstEntityService;

    @GetMapping("/first")
    public ResponseEntity<List<FirstEntity>> getAllFirstEntity(){
        return new ResponseEntity<>(firstEntityService.getAll(), HttpStatus.OK);
    }
}
