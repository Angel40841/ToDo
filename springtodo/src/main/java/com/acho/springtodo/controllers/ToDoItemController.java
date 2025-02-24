package com.acho.springtodo.controllers;

import com.acho.springtodo.repositories.ToDoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoItemController {
    private final Logger logger = LoggerFactory.getLogger(ToDoItemController.class);
    private final ToDoItemRepository toDoItemRepository;

    public ToDoItemController(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        logger.info("request to GET index");

        model.addAttribute("toDoItems", toDoItemRepository.findAll());
      return "index";
    }

}
