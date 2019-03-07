package com.codecool.todoapp.Entity;

import com.codecool.todoapp.Status;
import lombok.*;

import javax.persistence.*;

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

    @Enumerated(value = EnumType.STRING)
    private Status status;

    private boolean completed;
}
