package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.ArticuloRequest;
import com.pragma.Emazon.application.dto.CategoriaRequest;
import com.pragma.Emazon.application.dto.MarcaRequest;
import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.model.Marca;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ArticuloRequestMapperTest {

    private final ArticuloRequestMapper mapper = Mappers.getMapper(ArticuloRequestMapper.class);

    @Test
    void toArticulo() {
        // Arrange
        Categoria categoriaRequest = new Categoria();
        categoriaRequest.setId(1L);

        Marca marcaRequest = new Marca();
        marcaRequest.setId(2L);

        ArticuloRequest articuloRequest = new ArticuloRequest();
        articuloRequest.setCantidad(10);
        articuloRequest.setPrecio(99.99);
        articuloRequest.setCategoria(categoriaRequest);
        articuloRequest.setMarca(marcaRequest);

        // Act
        Articulo articulo = mapper.toArticulo(articuloRequest);

        // Assert
        assertEquals(10, articulo.getCantidad());
        assertEquals(99.99, articulo.getPrecio());
        assertEquals(1L, articulo.getIdCategoria());
        assertEquals(2L, articulo.getIdMarca());
    }
}