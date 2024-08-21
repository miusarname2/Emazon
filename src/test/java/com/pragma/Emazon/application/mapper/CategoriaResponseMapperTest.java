package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.CategoriaResponse;
import com.pragma.Emazon.domain.model.Categoria;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaResponseMapperTest {

    private CategoriaResponseMapper mapper = Mappers.getMapper(CategoriaResponseMapper.class);

    @Test
    void toResponse() {
        // Arrange
        Categoria categoria = new Categoria();
        categoria.setNombre("Electrónica");
        categoria.setDescripcion("Productos electrónicos");

        // Act
        CategoriaResponse response = mapper.toResponse(categoria);

        // Assert
        assertEquals(categoria.getNombre(), response.getNombre());
        assertEquals(categoria.getDescripcion(), response.getDescripcion());
    }

    @Test
    void toResponseList() {
        // Arrange
        Categoria categoria1 = new Categoria();
        categoria1.setNombre("Electrónica");
        categoria1.setDescripcion("Productos electrónicos");

        Categoria categoria2 = new Categoria();
        categoria2.setNombre("Hogar");
        categoria2.setDescripcion("Productos para el hogar");

        List<Categoria> categorias = Arrays.asList(categoria1, categoria2);

        // Act
        List<CategoriaResponse> responseList = mapper.toResponseList(categorias);

        // Assert
        assertEquals(2, responseList.size());
        assertEquals("Electrónica", responseList.get(0).getNombre());
        assertEquals("Hogar", responseList.get(1).getNombre());
    }

}