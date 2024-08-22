package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.MarcaResponse;
import com.pragma.Emazon.domain.model.Marca;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarcaResponseMapperTest {

    private final MarcaResponseMapper mapper = Mappers.getMapper(MarcaResponseMapper.class);

    @Test
    void toResponse() {
        // Arrange
        Marca marca = new Marca();
        marca.setId(1L);
        marca.setNombre("Electrónica");
        marca.setDescripcion("Productos electrónicos");

        // Act
        MarcaResponse response = mapper.toResponse(marca);

        // Assert
        assertEquals(1L, response.getId());
        assertEquals("Electrónica", response.getNombre());
        assertEquals("Productos electrónicos", response.getDescripcion());
    }

    @Test
    void toResponseList() {
        // Arrange
        Marca marca1 = new Marca();
        marca1.setId(1L);
        marca1.setNombre("Electrónica");
        marca1.setDescripcion("Productos electrónicos");

        Marca marca2 = new Marca();
        marca2.setId(2L);
        marca2.setNombre("Ropa");
        marca2.setDescripcion("Prendas de vestir");

        List<Marca> marcaList = Arrays.asList(marca1, marca2);

        // Act
        List<MarcaResponse> responseList = mapper.toResponseList(marcaList);

        // Assert
        assertEquals(2, responseList.size());

        MarcaResponse response1 = responseList.get(0);
        assertEquals(1L, response1.getId());
        assertEquals("Electrónica", response1.getNombre());
        assertEquals("Productos electrónicos", response1.getDescripcion());

        MarcaResponse response2 = responseList.get(1);
        assertEquals(2L, response2.getId());
        assertEquals("Ropa", response2.getNombre());
        assertEquals("Prendas de vestir", response2.getDescripcion());
    }

}