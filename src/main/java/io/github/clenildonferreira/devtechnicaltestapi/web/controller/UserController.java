package io.github.clenildonferreira.devtechnicaltestapi.web.controller;

import io.github.clenildonferreira.devtechnicaltestapi.entity.User;
import io.github.clenildonferreira.devtechnicaltestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User usuario = userService.salva(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
}
