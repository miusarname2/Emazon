package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.Rol;
import com.pragma.Emazon.infrastructure.output.jpa.entity.RolEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class RolEntityMapperTest {

    private final RolEntityMapper mapper = Mappers.getMapper(RolEntityMapper.class);

    @Test
    void toEntity() {
        // Arrange
        Rol rol = new Rol();
        rol.setId(1L);
        rol.setNombre("Admin");

        // Act
        RolEntity rolEntity = mapper.toEntity(rol);

        // Assert
        assertEquals(rol.getId(), rolEntity.getId());
        assertEquals(rol.getNombre(), rolEntity.getNombre());
    }

    @Test
    void toRol() {
        // Arrange
        RolEntity rolEntity = new RolEntity();
        rolEntity.setId(1L);
        rolEntity.setNombre("Admin");

        // Act
        Rol rol = mapper.toRol(rolEntity);

        // Assert
        assertEquals(rolEntity.getId(), rol.getId());
        assertEquals(rolEntity.getNombre(), rol.getNombre());
    }

}