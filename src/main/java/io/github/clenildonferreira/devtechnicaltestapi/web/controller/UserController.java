package io.github.clenildonferreira.devtechnicaltestapi.web.controller;

import io.github.clenildonferreira.devtechnicaltestapi.entity.User;
import io.github.clenildonferreira.devtechnicaltestapi.service.UserService;
import io.github.clenildonferreira.devtechnicaltestapi.web.dto.UserCreateDto;
import io.github.clenildonferreira.devtechnicaltestapi.web.dto.UserPasswordDto;
import io.github.clenildonferreira.devtechnicaltestapi.web.dto.UserResponseDto;
import io.github.clenildonferreira.devtechnicaltestapi.web.dto.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserCreateDto createDto) {
        User user = userService.salva(UserMapper.toUser(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) {
        User user = userService.searchById(id);
        return ResponseEntity.ok(UserMapper.toDto(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UserPasswordDto dto) {
        User user = userService.editPassword(id, dto.getCurrentPassword(), dto.getNewPassword(), dto.getConfirmPassword());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() {
        List<User> users = userService.searchAll();
        return ResponseEntity.ok(UserMapper.toListDto(users));
    }
}
