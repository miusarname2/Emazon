package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.TipoDocumento;
import com.pragma.Emazon.infrastructure.output.jpa.entity.TipoDocumentoEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class TipoDocumentoEntityMapperTest {

    private final TipoDocumentoEntityMapper mapper = Mappers.getMapper(TipoDocumentoEntityMapper.class);

    @Test
    void toEntity() {
        // Arrange
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setId(1L);
        tipoDocumento.setNombre("DNI");

        // Act
        TipoDocumentoEntity tipoDocumentoEntity = mapper.toEntity(tipoDocumento);

        // Assert
        assertEquals(tipoDocumento.getId(), tipoDocumentoEntity.getId());
        assertEquals(tipoDocumento.getNombre(), tipoDocumentoEntity.getNombre());
    }

    @Test
    void toTipoDocumento() {
        // Arrange
        TipoDocumentoEntity tipoDocumentoEntity = new TipoDocumentoEntity();
        tipoDocumentoEntity.setId(1L);
        tipoDocumentoEntity.setNombre("DNI");

        // Act
        TipoDocumento tipoDocumento = mapper.toTipoDocumento(tipoDocumentoEntity);

        // Assert
        assertEquals(tipoDocumentoEntity.getId(), tipoDocumento.getId());
        assertEquals(tipoDocumentoEntity.getNombre(), tipoDocumento.getNombre());
    }

}