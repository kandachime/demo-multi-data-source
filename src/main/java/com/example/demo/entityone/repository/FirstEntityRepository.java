package com.example.demo.entityone.repository;

import com.example.demo.entityone.FirstEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FirstEntityRepository extends JpaRepository<FirstEntity, Integer>, FirstEntityStoredProcedureRepository {


}
