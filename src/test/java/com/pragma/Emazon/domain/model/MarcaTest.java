package com.pragma.Emazon.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarcaTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Marca marca = new Marca();
        Long expectedId = 1L;
        String expectedNombre = "Electrónica";
        String expectedDescripcion = "Productos electrónicos";

        // Act
        marca.setId(expectedId);
        marca.setNombre(expectedNombre);
        marca.setDescripcion(expectedDescripcion);

        // Assert
        assertEquals(expectedId, marca.getId(), "El ID debería ser igual al esperado.");
        assertEquals(expectedNombre, marca.getNombre(), "El nombre debería ser igual al esperado.");
        assertEquals(expectedDescripcion, marca.getDescripcion(), "La descripción debería ser igual a la esperada.");
    }

}