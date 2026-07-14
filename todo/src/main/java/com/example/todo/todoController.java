package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")

public class todoController {
    @Autowired

    todoService service;

    @GetMapping("/getAll")
    public List<Todo> getAllTask(){
        return service.getAllTask();
    }

    @GetMapping("/get/{id}")
    public Todo getTaskById(@PathVariable Long id){
        return service.getTaskById(id);
    }

    @PostMapping("/new")
    public Todo saveTask(@RequestBody Todo t){
        return service.saveTask(t);
    }

    @PutMapping("/update/{id}")
    public Todo updateTask(@PathVariable long id,@RequestBody Todo t){
        return service.updateTask(id,t);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }
}
