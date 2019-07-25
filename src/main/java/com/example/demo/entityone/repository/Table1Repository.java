package com.example.demo.entityone.repository;

import com.example.demo.entityone.FirstEntity;
import com.example.demo.entityone.Table1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Table1Repository extends JpaRepository<Table1, Integer> {
}
