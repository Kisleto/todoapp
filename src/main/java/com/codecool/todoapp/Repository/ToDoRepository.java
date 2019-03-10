package com.codecool.todoapp.Repository;

import com.codecool.todoapp.Entity.ToDo;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    void deleteById(long id);

    @Modifying
    @Query("update ToDo t set t.completed = ?1 where t.id = ?2")
    @Transactional
    void toggleUpdate(boolean status, Long id);

    @Modifying
    @Query("update ToDo t set t.completed = ?1")
    @Transactional
    void toggleAll(boolean status);


    List<ToDo> findByCompletedTrue();

    List<ToDo> findByCompletedFalse();

    void deleteByTitle(@NonNull String title);

    ToDo findByTitle(String title);


}
