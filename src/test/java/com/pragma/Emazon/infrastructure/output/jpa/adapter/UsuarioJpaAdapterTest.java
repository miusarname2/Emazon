package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Usuario;
import com.pragma.Emazon.infrastructure.output.jpa.entity.UsuarioEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.UsuarioEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IUsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioJpaAdapterTest {

    @Mock
    private IUsuarioRepository usuarioRepository;

    @Mock
    private UsuarioEntityMapper usuarioEntityMapper;

    @InjectMocks
    private UsuarioJpaAdapter usuarioJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveUsuario_savesAndReturnsUsuario() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan Pérez");
        usuario.setCorreo("juan.perez@example.com");

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNombre("Juan Pérez");
        usuarioEntity.setCorreo("juan.perez@example.com");

        when(usuarioEntityMapper.toEntity(usuario)).thenReturn(usuarioEntity);
        when(usuarioRepository.save(usuarioEntity)).thenReturn(usuarioEntity);
        when(usuarioEntityMapper.toUsuario(usuarioEntity)).thenReturn(usuario);

        // Act
        Usuario savedUsuario = usuarioJpaAdapter.saveUsuario(usuario);

        // Assert
        assertEquals(usuario, savedUsuario, "El usuario guardado debería ser igual al esperado.");
        verify(usuarioEntityMapper).toEntity(usuario);
        verify(usuarioRepository).save(usuarioEntity);
        verify(usuarioEntityMapper).toUsuario(usuarioEntity);
    }

}