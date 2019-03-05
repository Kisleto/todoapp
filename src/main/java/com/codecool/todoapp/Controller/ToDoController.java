package com.codecool.todoapp.Controller;

import com.codecool.todoapp.Entity.ToDo;
import com.codecool.todoapp.Repository.ToDoRepository;
import com.codecool.todoapp.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    //Gets all predefined todos from db
    @PostMapping("/list")
    public List<ToDo> toDoList() {
        return toDoRepository.findAll();
    }

    //Adds new Todo
    @PostMapping("/addTodo")
    public void addTodo(@RequestParam("todo-title") String newTodo) {
        toDoRepository.save(ToDo.builder()
                .title(newTodo)
                .status(Status.ACTIVE)
                .build());
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable Long id) {
        toDoRepository.deleteById(id);
    }

}
