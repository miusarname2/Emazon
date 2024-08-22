package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.Marca;
import com.pragma.Emazon.infrastructure.output.jpa.entity.MarcaEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarcaEntityMapperTest {

    private final MarcaEntityMapper mapper = Mappers.getMapper(MarcaEntityMapper.class);

    @Test
    void toEntity() {
        // Arrange
        Marca marca = new Marca();
        marca.setId(1L);
        marca.setNombre("Electrónica");
        marca.setDescripcion("Productos electrónicos");

        // Act
        MarcaEntity marcaEntity = mapper.toEntity(marca);

        // Assert
        assertEquals(marca.getId(), marcaEntity.getId());
        assertEquals(marca.getNombre(), marcaEntity.getNombre());
        assertEquals(marca.getDescripcion(), marcaEntity.getDescripcion());
    }

    @Test
    void toMarca() {
        // Arrange
        MarcaEntity marcaEntity = new MarcaEntity();
        marcaEntity.setId(1L);
        marcaEntity.setNombre("Electrónica");
        marcaEntity.setDescripcion("Productos electrónicos");

        // Act
        Marca marca = mapper.toMarca(marcaEntity);

        // Assert
        assertEquals(marcaEntity.getId(), marca.getId());
        assertEquals(marcaEntity.getNombre(), marca.getNombre());
        assertEquals(marcaEntity.getDescripcion(), marca.getDescripcion());
    }

    @Test
    void toMarcaList() {
        // Arrange
        MarcaEntity marcaEntity1 = new MarcaEntity();
        marcaEntity1.setId(1L);
        marcaEntity1.setNombre("Electrónica");
        marcaEntity1.setDescripcion("Productos electrónicos");

        MarcaEntity marcaEntity2 = new MarcaEntity();
        marcaEntity2.setId(2L);
        marcaEntity2.setNombre("Hogar");
        marcaEntity2.setDescripcion("Productos para el hogar");

        List<MarcaEntity> marcaEntityList = Arrays.asList(marcaEntity1, marcaEntity2);

        // Act
        List<Marca> marcaList = mapper.toMarcaList(marcaEntityList);

        // Assert
        assertEquals(2, marcaList.size());
        assertEquals(marcaEntity1.getId(), marcaList.get(0).getId());
        assertEquals(marcaEntity2.getNombre(), marcaList.get(1).getNombre());
    }

}