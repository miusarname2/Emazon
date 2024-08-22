package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.infrastructure.output.jpa.entity.CategoriaEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

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

    @Test
    void toCategoria() {
        // Arrange
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNombre("Electrónica");
        categoriaEntity.setDescripcion("Productos electrónicos");

        // Act
        Categoria categoria = mapper.toCategoria(categoriaEntity);

        // Assert
        assertEquals("Electrónica", categoria.getNombre());
        assertEquals("Productos electrónicos", categoria.getDescripcion());
    }

    @Test
    void toCategoriaList() {
        // Arrange
        CategoriaEntity categoriaEntity1 = new CategoriaEntity();
        categoriaEntity1.setNombre("Electrónica");
        categoriaEntity1.setDescripcion("Productos electrónicos");

        CategoriaEntity categoriaEntity2 = new CategoriaEntity();
        categoriaEntity2.setNombre("Hogar");
        categoriaEntity2.setDescripcion("Artículos para el hogar");

        List<CategoriaEntity> categoriaEntityList = Arrays.asList(categoriaEntity1, categoriaEntity2);

        // Act
        List<Categoria> categoriaList = mapper.toCategoriaList(categoriaEntityList);

        // Assert
        assertEquals(2, categoriaList.size());
        assertEquals("Electrónica", categoriaList.get(0).getNombre());
        assertEquals("Productos electrónicos", categoriaList.get(0).getDescripcion());
        assertEquals("Hogar", categoriaList.get(1).getNombre());
        assertEquals("Artículos para el hogar", categoriaList.get(1).getDescripcion());
    }

}