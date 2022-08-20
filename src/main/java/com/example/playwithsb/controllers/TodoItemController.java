package com.example.playwithsb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class TodoItemController {
    private final Logger log=LoggerFactory.getLogger(TodoItemController.class);
    @GetMapping("/")
    public ModelAndView index() {
        log.debug("Request to Get Index");
        ModelAndView modelAndView= new ModelAndView("index");
        return modelAndView;
    }
    
}
