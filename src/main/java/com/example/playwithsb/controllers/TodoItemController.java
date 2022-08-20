package com.example.playwithsb.controllers;

import com.example.playwithsb.repositories.TodoItemRepository;
import java.time.Instant;
import java.time.ZoneId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    modelAndView.addObject(
      "today",
      Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek()
    );

    modelAndView.addObject("todoItems", todoItemRepository.findAll());
    return modelAndView;
  }
}
