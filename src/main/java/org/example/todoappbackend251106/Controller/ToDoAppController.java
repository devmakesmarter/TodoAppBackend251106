package org.example.todoappbackend251106.Controller;


import org.example.todoappbackend251106.Components.TodoComponentDto;
import org.example.todoappbackend251106.Components.TodoComponent;
import org.example.todoappbackend251106.Service.ToDoAppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ToDoAppController {

    private final ToDoAppService toDoAppService;

    public ToDoAppController(ToDoAppService toDoAppService){
        this.toDoAppService = toDoAppService;
    }


    @GetMapping("api/todo")
    public List<TodoComponent> getAllToDo(){
         return toDoAppService.getAllToDo();

    }

    @PostMapping("api/todo")
    public TodoComponent addTodo(@RequestBody TodoComponentDto todoComponentDto){
        return toDoAppService.addTodo(todoComponentDto);

    }

    @GetMapping("api/todo/{id}")
    public TodoComponent getTodoById(@PathVariable String id){
        TodoComponent toReturn;
         return toReturn = toDoAppService.getTodoByid(id);
    }


    @PutMapping("api/todo/{id}")
    public TodoComponent modifyTodo(@RequestBody TodoComponentDto todoComponentDto, @PathVariable String id){
       return toDoAppService.modifyTodo(todoComponentDto,id);

    }


    @DeleteMapping("api/todo/{id}")
    public TodoComponent deleteTodoById(@PathVariable String id){
        TodoComponent todoComponent = toDoAppService.getTodoByid(id);
        toDoAppService.deleteTodoById(todoComponent.id());
        return todoComponent;
    }

}
