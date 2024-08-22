package com.pragma.Emazon.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaResponseTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        CategoriaResponse categoriaResponse = new CategoriaResponse();
        categoriaResponse.setNombre("Electrónica");
        categoriaResponse.setDescripcion("Productos electrónicos");

        // Act
        String nombre = categoriaResponse.getNombre();
        String descripcion = categoriaResponse.getDescripcion();

        // Assert
        assertEquals("Electrónica", nombre, "El nombre debería ser 'Electrónica'");
        assertEquals("Productos electrónicos", descripcion, "La descripción debería ser 'Productos electrónicos'");
    }

}