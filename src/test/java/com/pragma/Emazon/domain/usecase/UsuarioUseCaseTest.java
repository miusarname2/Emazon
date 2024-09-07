package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.model.Usuario;
import com.pragma.Emazon.domain.spi.IUsuarioPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioUseCaseTest {

    @Mock
    private IUsuarioPersistence usuarioPersistence;

    @InjectMocks
    private UsuarioUseCase usuarioUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveUsuario() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Juan");
        usuario.setApellido("Pérez");
        usuario.setCorreo("juan.perez@example.com");
        usuario.setCelular("123456789");
        usuario.setFecha_nacimiento(new java.util.Date());
        usuario.setClave("password");
        usuario.setDocumento("12345678");
        usuario.setIdTipoDocumento(1L);
        usuario.setId_rol(2L);

        when(usuarioPersistence.saveUsuario(usuario)).thenReturn(usuario);

        // Act
        Usuario result = usuarioUseCase.saveUsuario(usuario);

        // Assert
        verify(usuarioPersistence).saveUsuario(usuario);
        assertEquals(usuario, result, "El usuario devuelto debería ser igual al esperado.");
    }

}