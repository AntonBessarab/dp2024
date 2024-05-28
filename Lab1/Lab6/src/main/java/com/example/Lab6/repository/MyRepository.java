package com.example.Lab6.repository;

import com.example.Lab6.entity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "myEntities", path = "myEntities")
public interface MyRepository extends JpaRepository<MyEntity, Long> {
}