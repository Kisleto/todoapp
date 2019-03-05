package com.codecool.todoapp.Repository;

import com.codecool.todoapp.Entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    void deleteById(Integer id);
}
