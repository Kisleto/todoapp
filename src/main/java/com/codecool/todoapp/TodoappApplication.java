package com.codecool.todoapp;

import com.codecool.todoapp.Entity.ToDo;
import com.codecool.todoapp.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class TodoappApplication {

    @Autowired
    ToDoRepository toDoRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodoappApplication.class, args);
    }


    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            ToDo toDo = ToDo.builder()
                    .title("TODO 1")
                    .completed(false)
                    .build();
            toDoRepository.save(toDo);

        };
    }
}
