package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.TipoDocumentoResponse;
import com.pragma.Emazon.domain.model.TipoDocumento;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class TipoDocumentoResponseMapperTest {

    private final TipoDocumentoResponseMapper tipoDocumentoResponseMapper = Mappers.getMapper(TipoDocumentoResponseMapper.class);

    @Test
    void testToResponse() {
        // Arrange
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setId(1L);
        tipoDocumento.setNombre("Cédula");
        tipoDocumento.setDescripcion("Documento de identificación");

        // Act
        TipoDocumentoResponse tipoDocumentoResponse = tipoDocumentoResponseMapper.toResponse(tipoDocumento);

        // Assert
        assertNotNull(tipoDocumentoResponse);
        assertEquals(tipoDocumento.getNombre(), tipoDocumentoResponse.getNombre());
        assertEquals(tipoDocumento.getDescripcion(), tipoDocumentoResponse.getDescripcion());
    }

}