package com.example.demo.controller;

import com.example.demo.entityone.FirstEntity;
import com.example.demo.service.FirstEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FirstController {

    @Autowired
    private FirstEntityService firstEntityService;

    @GetMapping("/firsts")
    public ResponseEntity<List<FirstEntity>> getAllFirstEntity(){
        return new ResponseEntity<>(firstEntityService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/countFirst/{id}")
    public ResponseEntity<Long> countFirstEntity(@PathVariable Long id){
        return new ResponseEntity<>(firstEntityService.countAllStoredProd(id), HttpStatus.OK);
    }
}
