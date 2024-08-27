package com.pragma.Emazon.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.model.Marca;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticuloRequestTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        ArticuloRequest articuloRequest = new ArticuloRequest();
        String nombre = "Producto";
        String descripcion = "Descripción del producto";
        int cantidad = 10;
        double precio = 99.99;
        Categoria categoria = new Categoria();
        Marca marca = new Marca();

        // Act
        articuloRequest.setNombre(nombre);
        articuloRequest.setDescripcion(descripcion);
        articuloRequest.setCantidad(cantidad);
        articuloRequest.setPrecio(precio);
        articuloRequest.setCategoria(categoria);
        articuloRequest.setMarca(marca);

        // Assert
        assertEquals(nombre, articuloRequest.getNombre());
        assertEquals(descripcion, articuloRequest.getDescripcion());
        assertEquals(cantidad, articuloRequest.getCantidad());
        assertEquals(precio, articuloRequest.getPrecio());
        assertEquals(categoria, articuloRequest.getCategoria());
        assertEquals(marca, articuloRequest.getMarca());
    }

    @Test
    void testNombreSizeValidation() {
        // Arrange
        ArticuloRequest articuloRequest = new ArticuloRequest();
        String nombreLargo = "Nombre que excede el límite de cincuenta caracteres, lo cual debería provocar un error";

        // Act
        Exception exception = assertThrows(Exception.class, () -> {
            articuloRequest.setNombre(nombreLargo);
        });

        // Assert
        assertTrue(exception.getMessage().contains("El nombre no puede tener más de 50 caracteres"));
    }

    @Test
    void testDescripcionSizeValidation() {
        // Arrange
        ArticuloRequest articuloRequest = new ArticuloRequest();
        String descripcionLarga = "Esta descripción es muy larga y excede el límite de noventa caracteres, lo que debería provocar un error";

        // Act
        Exception exception = assertThrows(Exception.class, () -> {
            articuloRequest.setDescripcion(descripcionLarga);
        });

        // Assert
        assertTrue(exception.getMessage().contains("La descripción no puede superar los 90 caracteres."));
    }
}
