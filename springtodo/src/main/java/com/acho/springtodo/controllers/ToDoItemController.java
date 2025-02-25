package com.acho.springtodo.controllers;

import com.acho.springtodo.models.ToDoItem;
import com.acho.springtodo.repositories.ToDoItemRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;

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
@PostMapping("/todo/{id}")
    public String updateToDoItem(@PathVariable("id") long id, @Valid ToDoItem todoItem, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
        todoItem.setId(id);
        return "update-todo-item";

    }
    todoItem.setModifiedDate(Instant.now());
    toDoItemRepository.save(todoItem);
    return "redirect:/";
}


}
