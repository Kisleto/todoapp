package com.codecool.todoapp.Controller;

import com.codecool.todoapp.Entity.ToDo;
import com.codecool.todoapp.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Controller
@Component
@Transactional
public class ToDoController {

    private static final String SUCCESS = "{\"success\":true}";

    @Autowired
    private ToDoRepository toDoRepository;

    //Gets all predefined todos from db
    @PostMapping("/list")
    public List<ToDo> toDoList(@RequestParam String status) {
        if (status.equals("active")) {
            return toDoRepository.findByCompletedFalse();
        }
        if (status.equals("complete")) {
            return toDoRepository.findByCompletedTrue();
        }
        return toDoRepository.findAll();
    }

    //Adds new to do
    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo-title") String newTodo) {
        toDoRepository.save(ToDo.builder()
                .title(newTodo)
                .completed(false)
                .build());
        return SUCCESS;
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable Long id) {
        toDoRepository.deleteById(id);
    }

    @PutMapping("/todos/{id}/toggle_status")
    public String toggleCompleted(@RequestParam String status, @PathVariable("id") Long id) {
        if (status.equals("true")) {
            toDoRepository.toggleUpdate(true, id);
            return SUCCESS;
        } else {
            toDoRepository.toggleUpdate(false, id);
            return SUCCESS;
        }
    }


    @DeleteMapping("/todos/completed")
    public void deleteAllCompleted() {
        toDoRepository.findByCompletedTrue().forEach(toDo -> toDoRepository.delete(toDo));
    }


    @PutMapping("/todos/{id}")
    public void editTodo(@RequestParam("todo-title") String title, @PathVariable Long id) {
        toDoRepository.findById(id).ifPresent(toDo -> toDo.setTitle(title));
    }

    @PutMapping("/todos/toggle_all")
    public void toggleAll(@RequestParam("toggle-all") String status) {
        if (status.equals("true")) {
            toDoRepository.findByCompletedFalse().forEach(toDo -> toDo.setCompleted(true));
        } else if (status.equals("false")) {
            toDoRepository.findByCompletedTrue().forEach(toDo -> toDo.setCompleted(false));
        }
    }


}
