package com.pragma.Emazon.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticuloTest {

    @Test
    void testSettersAndGetters() {
        // Arrange
        Articulo articulo = new Articulo();
        Long expectedId = 1L;
        int expectedCantidad = 10;
        double expectedPrecio = 99.99;
        Long expectedIdCategoria = 2L;
        Long expectedIdMarca = 3L;

        // Act
        articulo.setId(expectedId);
        articulo.setCantidad(expectedCantidad);
        articulo.setPrecio(expectedPrecio);
        articulo.setIdCategoria(expectedIdCategoria);
        articulo.setIdMarca(expectedIdMarca);

        // Assert
        assertEquals(expectedId, articulo.getId());
        assertEquals(expectedCantidad, articulo.getCantidad());
        assertEquals(expectedPrecio, articulo.getPrecio());
        assertEquals(expectedIdCategoria, articulo.getIdCategoria());
        assertEquals(expectedIdMarca, articulo.getIdMarca());
    }

}