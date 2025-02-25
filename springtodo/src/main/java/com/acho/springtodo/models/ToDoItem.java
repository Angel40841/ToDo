package com.acho.springtodo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "todo-item")
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Description cannot be blank!")
    private String description;

    @Getter
    @Setter
    private boolean complete;

    @Getter
    @Setter
    private Instant createdDate;

    @Getter
    @Setter
    private Instant modifiedDate;

    public ToDoItem() {
    }

    public ToDoItem(String description) {
        this.description = description;
        this.complete = false;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", complete=" + complete +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
