package com.example.playwithsb.controllers;

import com.example.playwithsb.models.TodoItem;
import com.example.playwithsb.repositories.TodoItemRepository;
import java.time.Instant;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoFormController {
  private final Logger log = LoggerFactory.getLogger(TodoFormController.class);

  @Autowired
  private TodoItemRepository todoItemRepository;

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable("id") long id, Model model) {
    TodoItem todoItem = todoItemRepository
      .findById(id)
      .orElseThrow(
        () -> new IllegalArgumentException("TodoItem id: " + id + " not found")
      );

    model.addAttribute("todo", todoItem);
    return "edit-todo-item";
  }

  @GetMapping("/create-todo-item")
  public String showCreateItemForm(TodoItem todoItem) {
    return "create-todo-item";
  }

  @GetMapping("/error")
  public String showError(HttpServletResponse response, Model model) {
    return "error";
  }

  @PostMapping("/todo/{id}")
  public String updateTodoItem(
    @PathVariable("id") long id,
    @Valid TodoItem todoItem,
    BindingResult result,
    Model model
  ) {
    log.debug("Request to update TodoItem: {}", todoItem);

    if (result.hasErrors()) {
      todoItem.setId(id);
      return "edit-todo-item";
    }
    todoItem.setUpdatedAt(Instant.now());
    todoItemRepository.save(todoItem);
    return "redirect:/";
  }

  @GetMapping("/delete/{id}")
  public String deleteTodoItem(@PathVariable("id") long id, Model model) {
    TodoItem todoItem = todoItemRepository
      .findById(id)
      .orElseThrow(
        () -> new IllegalArgumentException("TodoItem id: " + id + " not found")
      );

    todoItemRepository.delete(todoItem);
    return "redirect:/";
  }
}
