package com.todolist.todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todolist.entity.Todo;
import com.todolist.todolist.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
    
    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // HTTP REQUESTS

    @PostMapping
    public List<Todo> create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping
    public List<Todo> list() {
        return todoService.list();
    }
    
    @PutMapping
    public List<Todo> update(Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    public List<Todo> delete(@PathVariable("id") Integer id) {
        return todoService.delete(id);
    }
}
