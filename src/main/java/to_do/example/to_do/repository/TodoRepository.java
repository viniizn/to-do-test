package to_do.example.to_do.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import to_do.example.to_do.entities.ToDo;

public interface TodoRepository extends JpaRepository<ToDo, Long> {
}
