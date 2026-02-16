package to_do.example.to_do.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import to_do.example.to_do.entities.ToDo;
import to_do.example.to_do.repository.TodoRepository;

import java.util.List;

@Service
public class toDoService {
    private TodoRepository todoRepository;

    public toDoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<ToDo> create(ToDo toDo) {
        todoRepository.save(toDo);
        return views();
    }

    public List<ToDo> views() {
        Sort.by("prioridade").descending().and(
                Sort.by("name").ascending());
        return todoRepository.findAll();
    }

    public List<ToDo> update(ToDo toDo) {
        todoRepository.save(toDo);
        return views();
    }

    public List<ToDo> delete(Long id) {
        todoRepository.deleteById(id);
        return views();
    }
}
