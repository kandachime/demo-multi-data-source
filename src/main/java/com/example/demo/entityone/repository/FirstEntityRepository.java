package com.example.demo.entityone.repository;

import com.example.demo.entityone.FirstEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstEntityRepository extends JpaRepository<FirstEntity, Integer> {
}
