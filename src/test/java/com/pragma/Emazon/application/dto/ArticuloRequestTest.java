package com.pragma.Emazon.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticuloRequestTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        ArticuloRequest articuloRequest = new ArticuloRequest();
        int cantidad = 10;
        double precio = 99.99;
        Long idCategoria = 1L;
        Long idMarca = 2L;

        // Act
        articuloRequest.setCantidad(cantidad);
        articuloRequest.setPrecio(precio);
        articuloRequest.setIdCategoria(idCategoria);
        articuloRequest.setIdMarca(idMarca);

        // Assert
        assertEquals(cantidad, articuloRequest.getCantidad());
        assertEquals(precio, articuloRequest.getPrecio());
        assertEquals(idCategoria, articuloRequest.getIdCategoria());
        assertEquals(idMarca, articuloRequest.getIdMarca());
    }

}