package com.example.demo.entityone.repository;

import com.example.demo.entityone.Table2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Table2Repository extends JpaRepository<Table2, Integer> {
}
