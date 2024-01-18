package io.github.clenildonferreira.devtechnicaltestapi.service;

import io.github.clenildonferreira.devtechnicaltestapi.entity.User;
import io.github.clenildonferreira.devtechnicaltestapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public User salva(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User searchById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }

    @Transactional
    public User editPassword(Long id, String password) {
        User usuario = searchById(id);
        usuario.setPassword(password);
        return usuario;
    }
}
