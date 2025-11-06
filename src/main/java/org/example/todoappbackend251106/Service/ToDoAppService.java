package org.example.todoappbackend251106.Service;

import org.example.todoappbackend251106.Components.TodoComponent;
import org.example.todoappbackend251106.Components.TodoComponentDto;
import org.example.todoappbackend251106.Helpers.GenerateAnUniqueId;
import org.example.todoappbackend251106.Repository.ToDoAppRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoAppService {

    private final ToDoAppRepository toDoAppRepository;

    public ToDoAppService(ToDoAppRepository toDoAppRepository){
        this.toDoAppRepository = toDoAppRepository;
    }

    public List<TodoComponent> getAllToDo(){
        return toDoAppRepository.findAll();
    }

    public TodoComponent addTodo(TodoComponentDto todoComponentDto){

        TodoComponent todoCompenentToAdd = new TodoComponent(GenerateAnUniqueId.uniqueId(),todoComponentDto.description(), todoComponentDto.status());
        toDoAppRepository.save(todoCompenentToAdd);
        return todoCompenentToAdd;
    }

    public TodoComponent getTodoByid(String id){
        Optional<TodoComponent> toReturn =toDoAppRepository.findById(id);
        return toReturn.orElseThrow();
    }

    public TodoComponent deleteTodoById(String id ){
        TodoComponent toDelete =  toDoAppRepository.findById(id).orElseThrow();
        toDoAppRepository.delete(toDelete);
        return toDelete;
    }

    public TodoComponent modifyTodo(TodoComponentDto todoComponentDto, String id ){
        TodoComponent componentToDelete = toDoAppRepository.findById(id).orElseThrow();
        toDoAppRepository.delete(componentToDelete);
        TodoComponent componentToAdd = new TodoComponent(id, todoComponentDto.description(), todoComponentDto.status());
        toDoAppRepository.save(componentToAdd);
        return componentToAdd;


    }




}
