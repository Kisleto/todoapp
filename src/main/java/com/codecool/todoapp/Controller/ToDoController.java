package com.codecool.todoapp.Controller;

import com.codecool.todoapp.Entity.ToDo;
import com.codecool.todoapp.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ToDoController {
    @Autowired
    ToDoRepository toDoRepository;

    @PostMapping("/list")
    public List<ToDo> toDoList() {
        return toDoRepository.findAll();
    }

}
