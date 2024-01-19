package io.github.clenildonferreira.devtechnicaltestapi.service;

import io.github.clenildonferreira.devtechnicaltestapi.entity.User;
import io.github.clenildonferreira.devtechnicaltestapi.exception.EntityNotFoundException;
import io.github.clenildonferreira.devtechnicaltestapi.exception.PasswordInvalidException;
import io.github.clenildonferreira.devtechnicaltestapi.repository.UserRepository;

import io.github.clenildonferreira.devtechnicaltestapi.exception.UserNameUniqueViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public User salva(User user) {
        try {
            return userRepository.save(user);

        }catch (DataIntegrityViolationException ex) {
            throw new UserNameUniqueViolationException(String.format("Email {%s} ou CPF {%s} já cadastrado.", user.getUsername(), user.getCpf()));
        }
    }

    @Transactional(readOnly = true)
    public User searchById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário id=%s não encontrado.", id))
        );
    }

    @Transactional
    public User editPassword(Long id, String currentPassword, String newPassword, String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            throw new PasswordInvalidException("Nova senha não confere com a confirmação da senha.");
        }

        User user = searchById(id);
        if(!user.getPassword().equals(currentPassword)) {
            throw new PasswordInvalidException("Sua senha não confere.");
        }

        user.setPassword(newPassword);
        return user;
    }

    @Transactional(readOnly = true)
    public List<User> searchAll() {
        return userRepository.findAll();
    }
}
