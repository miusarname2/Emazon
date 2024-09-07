package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.RolResponse;
import com.pragma.Emazon.domain.model.Rol;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class RolResponseMapperTest {

    private final RolResponseMapper rolResponseMapper = Mappers.getMapper(RolResponseMapper.class);

    @Test
    void testToResponse() {
        // Arrange
        Rol rol = new Rol();
        rol.setId(1L);
        rol.setNombre("Administrador");
        rol.setDescripcion("Rol con todos los permisos");

        // Act
        RolResponse rolResponse = rolResponseMapper.toResponse(rol);

        // Assert
        assertNotNull(rolResponse);
        assertEquals(rol.getNombre(), rolResponse.getNombre());
        assertEquals(rol.getDescripcion(), rolResponse.getDescripcion());
    }

}