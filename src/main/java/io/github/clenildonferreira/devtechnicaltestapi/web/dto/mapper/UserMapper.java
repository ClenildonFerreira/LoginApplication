package io.github.clenildonferreira.devtechnicaltestapi.web.dto.mapper;

import io.github.clenildonferreira.devtechnicaltestapi.entity.Usuario;
import io.github.clenildonferreira.devtechnicaltestapi.web.dto.UserCreateDto;
import io.github.clenildonferreira.devtechnicaltestapi.web.dto.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static Usuario toUser(UserCreateDto userCreateDto) {
        return new ModelMapper().map(userCreateDto, Usuario.class);
    }

    public static UserResponseDto toDto(Usuario usuario) {
        String role = usuario.getRole().name().substring("ROLE_".length());
        PropertyMap<Usuario, UserResponseDto> props = new PropertyMap<Usuario, UserResponseDto>() {
            @Override
            protected void configure() {
                map().setRole(role);
            }
        };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(usuario, UserResponseDto.class);
    }

    public static List<UserResponseDto> toListDto(List<Usuario> usuarios) {
        return usuarios.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }
}
