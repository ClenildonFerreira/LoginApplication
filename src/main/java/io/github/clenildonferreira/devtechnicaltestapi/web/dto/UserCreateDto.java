package io.github.clenildonferreira.devtechnicaltestapi.web.dto;

import io.github.clenildonferreira.devtechnicaltestapi.entity.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserCreateDto {
    @NotBlank(message = "Nome é obrigatório!")
    private String name;
    @NotBlank(message = "CPF é obrigatório!")
    @CPF(message = "formato do cpf está invalido")
    private String cpf;
    @NotBlank(message = "E-mail é obrigatório!")
    @Email(message = "formato do e-mail está invalido", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
    private String username;
    @NotBlank(message = "Password é obrigatório!")
    @Size(min = 8, max = 20)
    private String password;

}
