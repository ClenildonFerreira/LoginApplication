package io.github.clenildonferreira.devtechnicaltestapi.repository;

import io.github.clenildonferreira.devtechnicaltestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
