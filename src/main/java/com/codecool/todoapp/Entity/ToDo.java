package com.codecool.todoapp.Entity;

import com.codecool.todoapp.Status;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDo {
    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String title;
    private Status status;

}
