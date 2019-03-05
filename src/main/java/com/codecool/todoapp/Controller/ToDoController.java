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

    //Adds new to do
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

    @PutMapping("/todos/{id}/toggle_status")
    public void toggleCompleted(@RequestParam boolean status, @PathVariable("id") Long id) {
        if (status) {
            toDoRepository.toggleUpdate(Status.COMPLETE, id);
            System.out.println(toDoRepository.toggleUpdate(Status.COMPLETE, id));

        } else {
            toDoRepository.toggleUpdate(Status.ACTIVE, id);
        }
    }

    @GetMapping("/todos/{id}")
    public void findById(@PathVariable("id") Long id) {
        toDoRepository.findById(id).ifPresent(null);

    }
}
