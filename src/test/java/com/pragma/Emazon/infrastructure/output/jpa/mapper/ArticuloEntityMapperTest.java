package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.infrastructure.output.jpa.entity.ArticuloEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ArticuloEntityMapperTest {

    private final ArticuloEntityMapper mapper = Mappers.getMapper(ArticuloEntityMapper.class);

    @Test
    void toEntity() {
        // Arrange
        Articulo articulo = new Articulo();
        articulo.setId(1L);
        articulo.setCantidad(10);
        articulo.setPrecio(99.99);
        articulo.setIdCategoria(2L);
        articulo.setIdMarca(3L);

        // Act
        ArticuloEntity articuloEntity = mapper.toEntity(articulo);

        // Assert
        assertEquals(1L, articuloEntity.getId());
        assertEquals(10, articuloEntity.getCantidad());
        assertEquals(99.99, articuloEntity.getPrecio());
        assertEquals(2L, articuloEntity.getIdCategoria());
        assertEquals(3L, articuloEntity.getIdMarca());
    }

    @Test
    void toArticulo() {
        // Arrange
        ArticuloEntity articuloEntity = new ArticuloEntity();
        articuloEntity.setId(1L);
        articuloEntity.setCantidad(10);
        articuloEntity.setPrecio(99.99);
        articuloEntity.setIdCategoria(2L);
        articuloEntity.setIdMarca(3L);

        // Act
        Articulo articulo = mapper.toArticulo(articuloEntity);

        // Assert
        assertEquals(1L, articulo.getId());
        assertEquals(10, articulo.getCantidad());
        assertEquals(99.99, articulo.getPrecio());
        assertEquals(2L, articulo.getIdCategoria());
        assertEquals(3L, articulo.getIdMarca());
    }

}