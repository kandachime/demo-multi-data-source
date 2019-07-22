package com.example.demo.entitytwo.repository;

import com.example.demo.entitytwo.SecondEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondEntityRepository extends JpaRepository<SecondEntity, Integer> {
}
