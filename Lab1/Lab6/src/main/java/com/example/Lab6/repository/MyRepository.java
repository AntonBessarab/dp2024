package com.example.Lab6.repository;

import com.example.Lab6.entity.Broniks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "myEntities", path = "myEntities")
public interface MyRepository extends JpaRepository<Broniks, Long> {
}