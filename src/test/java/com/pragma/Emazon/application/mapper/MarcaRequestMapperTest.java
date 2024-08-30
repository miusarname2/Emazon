package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.MarcaRequest;
import com.pragma.Emazon.domain.model.Marca;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class MarcaRequestMapperTest {

    private final MarcaRequestMapper mapper = Mappers.getMapper(MarcaRequestMapper.class);

    @Test
    void toMarca() {
        // Arrange
        MarcaRequest marcaRequest = new MarcaRequest();
        marcaRequest.setNombre("Electrónica");
        marcaRequest.setDescripcion("Productos electrónicos");

        // Act
        Marca marca = mapper.toMarca(marcaRequest);

        // Assert
        assertEquals("Electrónica", marca.getNombre());
        assertEquals("Productos electrónicos", marca.getDescripcion());
    }

}