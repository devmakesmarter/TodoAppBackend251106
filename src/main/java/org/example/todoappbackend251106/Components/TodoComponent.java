package org.example.todoappbackend251106.Components;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("todoappspring")
public record TodoComponent(@Id String id, String description, String status) {

}
