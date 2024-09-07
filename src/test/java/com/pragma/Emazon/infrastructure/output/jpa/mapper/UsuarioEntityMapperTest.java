package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.Usuario;
import com.pragma.Emazon.infrastructure.output.jpa.entity.UsuarioEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioEntityMapperTest {

    private final UsuarioEntityMapper mapper = Mappers.getMapper(UsuarioEntityMapper.class);

    @Test
    void toEntity() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Juan");
        usuario.setCorreo("juan@example.com");

        // Act
        UsuarioEntity usuarioEntity = mapper.toEntity(usuario);

        // Assert
        assertEquals(usuario.getId(), usuarioEntity.getId());
        assertEquals(usuario.getNombre(), usuarioEntity.getNombre());
        assertEquals(usuario.getCorreo(), usuarioEntity.getCorreo());
    }

    @Test
    void toUsuario() {
        // Arrange
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(1L);
        usuarioEntity.setNombre("Juan");
        usuarioEntity.setCorreo("juan@example.com");

        // Act
        Usuario usuario = mapper.toUsuario(usuarioEntity);

        // Assert
        assertEquals(usuarioEntity.getId(), usuario.getId());
        assertEquals(usuarioEntity.getNombre(), usuario.getNombre());
        assertEquals(usuarioEntity.getCorreo(), usuario.getCorreo());
    }

}