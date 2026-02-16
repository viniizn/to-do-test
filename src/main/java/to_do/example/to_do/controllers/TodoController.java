package to_do.example.to_do.controllers;

import org.springframework.web.bind.annotation.*;
import to_do.example.to_do.entities.ToDo;
import to_do.example.to_do.services.ToDoService;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private ToDoService toDoService;

    public TodoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    List<ToDo> create(@RequestBody ToDo toDo) {
        return toDoService.create(toDo);
    }

    @GetMapping
    List<ToDo> views() {
        return toDoService.views();
    }

    @PutMapping
    List<ToDo> update(@RequestBody ToDo toDo) {
        return toDoService.update(toDo);
    }

    @DeleteMapping("{id}")
    List<ToDo> delete(@PathVariable("id") Long id) {
        return toDoService.delete(id);
    }
}
