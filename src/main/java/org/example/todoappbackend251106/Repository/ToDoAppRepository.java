package org.example.todoappbackend251106.Repository;

import org.example.todoappbackend251106.Components.TodoComponent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoAppRepository extends MongoRepository<TodoComponent, String> {
}
