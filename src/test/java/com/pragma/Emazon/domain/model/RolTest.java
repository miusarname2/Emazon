package com.pragma.Emazon.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RolTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Rol rol = new Rol();
        Long expectedId = 1L;
        String expectedNombre = "Administrador";
        String expectedDescripcion = "Rol con acceso completo";

        // Act
        rol.setId(expectedId);
        rol.setNombre(expectedNombre);
        rol.setDescripcion(expectedDescripcion);

        // Assert
        assertEquals(expectedId, rol.getId(), "El ID debería ser igual al esperado.");
        assertEquals(expectedNombre, rol.getNombre(), "El nombre debería ser igual al esperado.");
        assertEquals(expectedDescripcion, rol.getDescripcion(), "La descripción debería ser igual a la esperada.");
    }

}