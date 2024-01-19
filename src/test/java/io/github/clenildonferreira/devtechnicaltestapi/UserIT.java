package io.github.clenildonferreira.devtechnicaltestapi;

import io.github.clenildonferreira.devtechnicaltestapi.web.dto.UserCreateDto;
import io.github.clenildonferreira.devtechnicaltestapi.web.dto.UserResponseDto;
import io.github.clenildonferreira.devtechnicaltestapi.web.exception.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/sql/users/users-insert.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/sql/users/users-delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

public class UserIT {
    @Autowired
    WebTestClient testClient;

    @Test
    public void createUser_WithUserNameAndPasswordValid_ReturnCreateUserWithStatusCode201() {
        UserResponseDto
                responseBody = testClient
                .post()
                .uri("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new UserCreateDto("Jose", "583.105.470-56", "jose@gmail.com", "12345678"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(UserResponseDto.class)
                .returnResult().getResponseBody();
        org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
        org.assertj.core.api.Assertions.assertThat(responseBody.getId()).isNotNull();
        org.assertj.core.api.Assertions.assertThat(responseBody.getName()).isEqualTo("Jose");
        org.assertj.core.api.Assertions.assertThat(responseBody.getCpf()).isEqualTo("583.105.470-56");
        org.assertj.core.api.Assertions.assertThat(responseBody.getUsername()).isEqualTo("jose@gmail.com");
    }
}
