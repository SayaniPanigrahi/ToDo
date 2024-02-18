package com.example.todoapplication.controller;

import com.example.todoapplication.entity.ToDo;
import com.example.todoapplication.service.TodoJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class TodoController {
    private final TodoJpaService todoJpaService;

    @Autowired
    public TodoController(TodoJpaService todoJpaService) {
        this.todoJpaService = todoJpaService;
    }

    @GetMapping
    public List<ToDo> getAllTodos() {
        return todoJpaService.getAlltodo();
    }

    @GetMapping("/{id}")
    public ToDo getTodoById(@PathVariable int id) throws Throwable {
        return todoJpaService.getToDoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToDo createTodo(@RequestBody ToDo todo) {
        return todoJpaService.createTodo(todo);
    }

    @PutMapping("/{id}")
    public ToDo updateTodo(@PathVariable int id, @RequestBody ToDo todo) {
        return todoJpaService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable int id) {
        todoJpaService.deleteTodo(id);
    }
}
