package com.example.demo.repository;

// CRUD - Create Read Update Delete

import com.example.demo.model.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface MyRepository extends CrudRepository<Pizza, Integer> {

}
