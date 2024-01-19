package io.github.clenildonferreira.devtechnicaltestapi.entity;

import io.github.clenildonferreira.devtechnicaltestapi.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Column(name = "cpf", nullable = false, unique = true, length = 50)
    private String cpf;
    @Column(name = "username", nullable = false, unique = true, length = 200)
    private String username;
    @Column(name = "password", nullable = false, length = 300)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 30)
    private UserRole role = UserRole.ROLE_USER;
    @Column(name = "createdDate")
    private LocalDateTime createdDate;
    @Column(name = "updateDate")
    private LocalDateTime updateDate;
    @Column(name = "createdAt")
    private String createdAt;
    @Column(name = "updateAt")
    private String updateAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
