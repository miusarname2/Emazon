package com.pragma.Emazon.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TipoDocumentoTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        TipoDocumento tipoDocumento = new TipoDocumento();
        Long expectedId = 1L;
        String expectedNombre = "DNI";
        String expectedDescripcion = "Documento Nacional de Identidad";

        // Act
        tipoDocumento.setId(expectedId);
        tipoDocumento.setNombre(expectedNombre);
        tipoDocumento.setDescripcion(expectedDescripcion);

        // Assert
        assertEquals(expectedId, tipoDocumento.getId(), "El ID debería ser igual al esperado.");
        assertEquals(expectedNombre, tipoDocumento.getNombre(), "El nombre debería ser igual al esperado.");
        assertEquals(expectedDescripcion, tipoDocumento.getDescripcion(), "La descripción debería ser igual a la esperada.");
    }

}