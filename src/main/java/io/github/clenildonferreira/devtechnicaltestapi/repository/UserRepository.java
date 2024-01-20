package io.github.clenildonferreira.devtechnicaltestapi.repository;

import io.github.clenildonferreira.devtechnicaltestapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
    @Query("select u.role from Usuario u where u.username like :username")
    Usuario.UserRole findRoleByUsername(String username);
}
