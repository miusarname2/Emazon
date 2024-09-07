package com.pragma.Emazon.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TipoDocumentoResponseTest {

    @Test
    void testGettersAndSetters(){
        // Arrange
        TipoDocumentoResponse tipoDocumentoResponse = new TipoDocumentoResponse();
        String nombre = "Cédula de Ciudadanía";
        String descripcion = "Documento nacional de identidad.";

        // Act
        tipoDocumentoResponse.setNombre(nombre);
        tipoDocumentoResponse.setDescripcion(descripcion);

        // Assert
        assertEquals(nombre, tipoDocumentoResponse.getNombre());
        assertEquals(descripcion, tipoDocumentoResponse.getDescripcion());
    }

}