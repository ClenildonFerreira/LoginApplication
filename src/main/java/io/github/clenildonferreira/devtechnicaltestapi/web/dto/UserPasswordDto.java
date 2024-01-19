package io.github.clenildonferreira.devtechnicaltestapi.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPasswordDto {
    @NotBlank(message = "Password é obrigatório!")
    @Size(min = 8, max = 20)
    private String currentPassword;
    @NotBlank(message = "Password é obrigatório!")
    @Size(min = 8, max = 20)
    private String newPassword;
    @NotBlank(message = "Password é obrigatório!")
    @Size(min = 8, max = 20)
    private String confirmPassword;
}
