package com.example.playwithsb.repositories;

import com.example.playwithsb.models.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {}
