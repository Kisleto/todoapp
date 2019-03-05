package com.codecool.todoapp.Repository;

import com.codecool.todoapp.Entity.ToDo;
import com.codecool.todoapp.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    void deleteById(long id);

    @Modifying
    @Query("update ToDo t set t.status = ?1 where t.id = ?2")
    @Transactional
    int toggleUpdate(Status status, Long id);

    Optional<ToDo> findById(Long id);

}
