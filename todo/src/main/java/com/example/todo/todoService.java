package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class todoService {

    @Autowired
    private todoRepository repository;

    // Get all tasks
    public List<Todo> getAllTask() {
        return repository.findAll();
    }

    // Get task by ID
    public Todo getTaskById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Save a new task
    public Todo saveTask(Todo t) {
        return repository.save(t);
    }

    // Update task
    public Todo updateTask(Long id, Todo t) {
        Todo existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setTask(t.getTask());
            existing.setCompleted(t.isCompleted());
            return repository.save(existing);
        }

        return null;
    }

    // Delete task
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}