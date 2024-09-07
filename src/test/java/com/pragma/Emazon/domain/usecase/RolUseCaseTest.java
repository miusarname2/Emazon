package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.model.Rol;
import com.pragma.Emazon.domain.spi.IRolPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RolUseCaseTest {

    @Mock
    private IRolPersistence rolPersistence;

    @InjectMocks
    private RolUseCase rolUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerRol() {
        // Arrange
        Long rolId = 1L;
        Rol expectedRol = new Rol();
        expectedRol.setId(rolId);
        expectedRol.setNombre("Administrador");
        expectedRol.setDescripcion("Rol con acceso completo");

        when(rolPersistence.obtenerRol(rolId)).thenReturn(expectedRol);

        // Act
        Rol result = rolUseCase.obtenerRol(rolId);

        // Assert
        verify(rolPersistence).obtenerRol(rolId);
        assertEquals(expectedRol, result, "El rol devuelto debería ser igual al rol esperado.");
    }

}