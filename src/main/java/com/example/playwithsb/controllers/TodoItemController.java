package com.example.playwithsb.controllers;

import com.example.playwithsb.models.TodoItem;
import com.example.playwithsb.repositories.TodoItemRepository;
import java.time.Instant;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoItemController {
  private final Logger log = LoggerFactory.getLogger(TodoItemController.class);

  @Autowired
  private TodoItemRepository todoItemRepository;

  @GetMapping("/")
  public ModelAndView index() {
    log.debug("Request to Get Index");
    ModelAndView modelAndView = new ModelAndView("index");

    modelAndView.addObject("todoItems", todoItemRepository.findAll());
    return modelAndView;
  }

  @PostMapping("/todo")
  public String createTodoItem(
    @Valid TodoItem todoItem,
    BindingResult result,
    Model model
  ) {
    if (result.hasErrors()) {
      return "create-todo-item";
    }

    todoItem.setCreatedAt(Instant.now());
    todoItem.setUpdatedAt(Instant.now());
    todoItemRepository.save(todoItem);
    return "redirect:/";
  }
}
