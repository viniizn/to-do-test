package to_do.example.to_do;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import to_do.example.to_do.entities.ToDo;

@SpringBootTest
class ToDoApplicationTests {
    @Autowired
    private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
        var todo = new ToDo("Tarefa test", "Desc teste", false, 2);

        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo(todo.getName())
                .jsonPath("$[0].description").isEqualTo(todo.getDescription())
                .jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
                .jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade())
	}

    @Test
    void testCreateTodoFailure() {

    }

}
