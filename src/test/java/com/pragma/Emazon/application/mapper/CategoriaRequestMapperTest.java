package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.CategoriaRequest;
import com.pragma.Emazon.domain.model.Categoria;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaRequestMapperTest {

    private CategoriaRequestMapper mapper = Mappers.getMapper(CategoriaRequestMapper.class);

    @Test
    void toCategoria() {
        // Arrange
        CategoriaRequest categoriaRequest = new CategoriaRequest();
        categoriaRequest.setNombre("Electrónica");
        categoriaRequest.setDescripcion("Productos electrónicos");

        // Act
        Categoria categoria = mapper.toCategoria(categoriaRequest);

        // Assert
        assertEquals(categoriaRequest.getNombre(), categoria.getNombre());
        assertEquals(categoriaRequest.getDescripcion(), categoria.getDescripcion());
    }

}