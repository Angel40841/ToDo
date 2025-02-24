package com.acho.springtodo.config;

import com.acho.springtodo.models.ToDoItem;
import com.acho.springtodo.repositories.ToDoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ToDoItemDataLoader implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(ToDoItemDataLoader.class);
    private final ToDoItemRepository toDoItemRepository;

    public ToDoItemDataLoader(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }


    @Override
    public void run(String... args) throws Exception {
loadData();
    }

    private void loadData() {
        if(toDoItemRepository.count() == 0){
            ToDoItem toDoItem = new ToDoItem("write some code");
            ToDoItem toDoItem1 = new ToDoItem("and repeat");
            toDoItemRepository.save(toDoItem);
            toDoItemRepository.save(toDoItem1);
        }
        logger.info("Number of to do items: {} ", toDoItemRepository.count());
    }

}
