package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.infrastructure.output.jpa.entity.CategoriaEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaEntityMapperTest {

    private final CategoriaEntityMapper mapper = Mappers.getMapper(CategoriaEntityMapper.class);

    @Test
    void toEntity() {
        // Arrange
        Categoria categoria = new Categoria();
        categoria.setNombre("Electrónica");
        categoria.setDescripcion("Productos electrónicos");

        // Act
        CategoriaEntity categoriaEntity = mapper.toEntity(categoria);

        // Assert
        assertEquals("Electrónica", categoriaEntity.getNombre());
        assertEquals("Productos electrónicos", categoriaEntity.getDescripcion());
    }

}