package com.example.playwithsb.configs;

import com.example.playwithsb.models.TodoItem;
import com.example.playwithsb.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDataLoader implements CommandLineRunner {
  final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

  @Autowired
  TodoItemRepository todoItemRepository;

  @Override
  public void run(String... args) throws Exception {
    seedData();
  }

  private void seedData() {
    if (todoItemRepository.count() == 0) {
      TodoItem todoItem1 = new TodoItem("Spring Boot", "Learn Spring Boot");
      TodoItem todoItem2 = new TodoItem("DS", "Try 3-4 problems");

      todoItemRepository.save(todoItem1);
      todoItemRepository.save(todoItem2);
    }
    logger.info("Number of TodoItems: {}", todoItemRepository.count());
  }
}
