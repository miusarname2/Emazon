package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Rol;
import com.pragma.Emazon.infrastructure.output.jpa.entity.RolEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.RolEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IRolRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RolJpaAdapterTest {

    @Mock
    private IRolRepository rolRepository;

    @Mock
    private RolEntityMapper rolEntityMapper;

    @InjectMocks
    private RolJpaAdapter rolJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerRol_whenRolExists_returnsRol() {
        // Arrange
        Long rolId = 1L;

        RolEntity rolEntity = new RolEntity();
        rolEntity.setId(rolId);
        rolEntity.setNombre("Admin");

        Rol rol = new Rol();
        rol.setId(rolId);
        rol.setNombre("Admin");

        when(rolRepository.getById(rolId)).thenReturn(rolEntity);
        when(rolEntityMapper.toRol(rolEntity)).thenReturn(rol);

        // Act
        Rol result = rolJpaAdapter.obtenerRol(rolId);

        // Assert
        assertEquals(rol, result, "El rol devuelto debería ser igual al esperado.");
        verify(rolRepository).getById(rolId);
        verify(rolEntityMapper).toRol(rolEntity);
    }

}