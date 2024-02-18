package com.example.todoapplication.repository;

import com.example.todoapplication.entity.ToDo;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration
public interface TodoRepository extends JpaRepository<ToDo,Integer> {
}
