package com.pragma.Emazon.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Electrónica");
        categoria.setDescripcion("Productos electrónicos");

        // Act
        Long id = categoria.getId();
        String nombre = categoria.getNombre();
        String descripcion = categoria.getDescripcion();

        // Assert
        assertEquals(1L, id, "El ID debería ser 1");
        assertEquals("Electrónica", nombre, "El nombre debería ser 'Electrónica'");
        assertEquals("Productos electrónicos", descripcion, "La descripción debería ser 'Productos electrónicos'");
    }

}