package com.acho.springtodo.controllers;

import com.acho.springtodo.repositories.ToDoItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ToDoFormController {
    private final ToDoItemRepository toDoItemRepository;

    public ToDoFormController(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){

    }

}
