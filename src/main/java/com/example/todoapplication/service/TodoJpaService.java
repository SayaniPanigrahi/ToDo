package com.example.todoapplication.service;

import com.example.todoapplication.entity.ToDo;
import com.example.todoapplication.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TodoJpaService {
    @Autowired
    private final TodoRepository todoRepository;

    public TodoJpaService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<ToDo> getAlltodo(){
        return todoRepository.findAll();
    }
    public ToDo getToDoById(int id) throws Throwable {
        return todoRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public ToDo createTodo(ToDo todo) {
        return (ToDo) todoRepository.save(todo);
    }

    public ToDo updateTodo(int id, ToDo todo) {
        if (!todoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        }
       todo.setId(id);
        return (ToDo) todoRepository.save(todo);
    }

    public void deleteTodo(int id) {
        if (!todoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        }
        todoRepository.deleteById(id);
    }
}
