package io.github.clenildonferreira.devtechnicaltestapi.service;

import io.github.clenildonferreira.devtechnicaltestapi.entity.Usuario;
import io.github.clenildonferreira.devtechnicaltestapi.exception.EntityNotFoundException;
import io.github.clenildonferreira.devtechnicaltestapi.exception.PasswordInvalidException;
import io.github.clenildonferreira.devtechnicaltestapi.repository.UserRepository;

import io.github.clenildonferreira.devtechnicaltestapi.exception.UserNameUniqueViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public Usuario salva(Usuario usuario) {
        try {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            return userRepository.save(usuario);

        }catch (DataIntegrityViolationException ex) {
            throw new UserNameUniqueViolationException(String.format("Email {%s} ou CPF {%s} já cadastrado.", usuario.getUsername(), usuario.getCpf()));
        }
    }

    @Transactional(readOnly = true)
    public Usuario searchById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário id=%s não encontrado.", id))
        );
    }

    @Transactional
    public Usuario editPassword(Long id, String currentPassword, String newPassword, String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            throw new PasswordInvalidException("Nova senha não confere com a confirmação da senha.");
        }

        Usuario user = searchById(id);
        if(!passwordEncoder.matches(currentPassword, user.getPassword())) {
            throw new PasswordInvalidException("Sua senha não confere.");
        }

        user.setPassword(passwordEncoder.encode(newPassword));

        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> searchAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario searchByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário com '%s' não encontrado", username))
        );
    }

    @Transactional(readOnly = true)
    public Usuario.UserRole searchRoleByUsername(String username) {
        return userRepository.findRoleByUsername(username);
    }

    @Transactional
    public void deleteUser(Usuario user) {
        userRepository.delete(user);
    }
}
