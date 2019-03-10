package com.codecool.todoapp;

import com.codecool.todoapp.Entity.ToDo;
import com.codecool.todoapp.Repository.ToDoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoTest {
    @Autowired
    ToDoRepository toDoRepository;

    ToDo toDo;

    public void setup() {
        toDoRepository.
                save(ToDo.builder()
                        .title("Hello")
                        .build());
    }

    @Test
    public void addNewToDo() {
        setup();
        Assert.assertEquals(2, toDoRepository.count());
    }

    @Test
    public void deleteToDo() {
        setup();
        toDoRepository.deleteByTitle("Hello");
        Assert.assertEquals(1, toDoRepository.count());
    }

    @Test
    public void editToDo() {
        setup();
        toDoRepository.findById(1L).ifPresent(toDo1 -> toDo1.setTitle("I changed"));
        Assert.assertEquals("I changed", toDoRepository.findByTitle("I changed").getTitle());
    }

}