package com.acho.springtodo.controllers;

import com.acho.springtodo.models.ToDoItem;
import com.acho.springtodo.repositories.ToDoItemRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.time.ZoneId;

@Controller
public class ToDoItemController {
    private final ToDoItemRepository toDoItemRepository;

    public ToDoItemController(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("toDoItems", toDoItemRepository.findAll());
        model.addAttribute("today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
        return "index";
    }
    @PostMapping("/todo")
    public String createTodoItem(@Valid ToDoItem toDoItem, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add-todo-item";
        }
        toDoItem.setCreatedDate(Instant.now());
        toDoItem.setModifiedDate(Instant.now());
        toDoItemRepository.save(toDoItem);
        return "redirect:/";
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
