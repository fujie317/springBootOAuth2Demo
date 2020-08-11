package com.datum.practice.repository;

import org.springframework.data.repository.CrudRepository;

import com.datum.practice.domain.ToDo;

public interface ToDoRepository extends CrudRepository<ToDo, String> {

}
