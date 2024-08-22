package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.ArticuloRequest;
import com.pragma.Emazon.domain.model.Articulo;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ArticuloRequestMapperTest {

    private final ArticuloRequestMapper mapper = Mappers.getMapper(ArticuloRequestMapper.class);

    @Test
    void toArticulo() {
        // Arrange
        ArticuloRequest articuloRequest = new ArticuloRequest();
        articuloRequest.setCantidad(10);
        articuloRequest.setPrecio(99.99);
        articuloRequest.setIdCategoria(1L);
        articuloRequest.setIdMarca(2L);

        // Act
        Articulo articulo = mapper.toArticulo(articuloRequest);

        // Assert
        assertEquals(10, articulo.getCantidad());
        assertEquals(99.99, articulo.getPrecio());
        assertEquals(1L, articulo.getIdCategoria());
        assertEquals(2L, articulo.getIdMarca());
    }

}