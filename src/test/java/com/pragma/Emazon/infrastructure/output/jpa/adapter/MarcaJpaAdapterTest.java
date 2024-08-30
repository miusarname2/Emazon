package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Marca;
import com.pragma.Emazon.infrastructure.exceptions.NoDataFound;
import com.pragma.Emazon.infrastructure.output.jpa.entity.MarcaEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.MarcaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IMarcaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MarcaJpaAdapterTest {

    @Mock
    private IMarcaRepository marcaRepository;

    @Mock
    private MarcaEntityMapper marcaEntityMapper;

    @InjectMocks
    private MarcaJpaAdapter marcaJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveMarca_whenMarcaExists_throwsException() {
        // Arrange
        Marca marca = new Marca();
        marca.setNombre("Electrónica");

        when(marcaRepository.existsByNombre("Electrónica")).thenReturn(true);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> marcaJpaAdapter.saveMarca(marca),
                "Debería lanzar una excepción cuando la marca ya existe.");
    }

    @Test
    void saveMarca_whenMarcaDoesNotExist_savesAndReturnsMarca() {
        // Arrange
        Marca marca = new Marca();
        marca.setNombre("Electrónica");
        marca.setDescripcion("Productos electrónicos");

        MarcaEntity marcaEntity = new MarcaEntity();
        marcaEntity.setNombre("Electrónica");
        marcaEntity.setDescripcion("Productos electrónicos");

        when(marcaRepository.existsByNombre("Electrónica")).thenReturn(false);
        when(marcaEntityMapper.toEntity(marca)).thenReturn(marcaEntity);
        when(marcaRepository.save(marcaEntity)).thenReturn(marcaEntity);
        when(marcaEntityMapper.toMarca(marcaEntity)).thenReturn(marca);

        // Act
        Marca savedMarca = marcaJpaAdapter.saveMarca(marca);

        // Assert
        assertEquals(marca, savedMarca, "La marca guardada debería ser igual a la esperada.");
        verify(marcaRepository).save(marcaEntity);
    }

    @Test
    void listMarca_withValidParams_returnsMarcaList() {
        // Arrange
        String sortBy = "nombre";
        boolean ascending = true;
        int page = 0;
        int size = 10;

        MarcaEntity marcaEntity1 = new MarcaEntity();
        marcaEntity1.setNombre("Electrónica");
        marcaEntity1.setDescripcion("Productos electrónicos");

        MarcaEntity marcaEntity2 = new MarcaEntity();
        marcaEntity2.setNombre("Hogar");
        marcaEntity2.setDescripcion("Productos para el hogar");

        List<MarcaEntity> marcaEntityList = Arrays.asList(marcaEntity1, marcaEntity2);

        Marca marca1 = new Marca();
        marca1.setNombre("Electrónica");
        marca1.setDescripcion("Productos electrónicos");

        Marca marca2 = new Marca();
        marca2.setNombre("Hogar");
        marca2.setDescripcion("Productos para el hogar");

        List<Marca> marcaList = Arrays.asList(marca1, marca2);

        Page<MarcaEntity> marcaEntityPage = new PageImpl<>(marcaEntityList);

        when(marcaRepository.findAll(any(Pageable.class))).thenReturn(marcaEntityPage);
        when(marcaEntityMapper.toMarcaList(marcaEntityList)).thenReturn(marcaList);

        // Act
        List<Marca> result = marcaJpaAdapter.listMarca(sortBy, ascending, page, size);

        // Assert
        assertEquals(marcaList, result, "La lista de marcas devuelta debería ser igual a la esperada.");
        verify(marcaRepository).findAll(any(Pageable.class));
    }

    @Test
    void listMarca_withNoDataFound_throwsNoDataFoundException() {
        // Arrange
        String sortBy = "nombre";
        boolean ascending = true;
        int page = 0;
        int size = 10;

        Page<MarcaEntity> emptyPage = new PageImpl<>(Collections.emptyList());

        when(marcaRepository.findAll(any(Pageable.class))).thenReturn(emptyPage);

        // Act & Assert
        assertThrows(NoDataFound.class, () -> marcaJpaAdapter.listMarca(sortBy, ascending, page, size),
                "Debería lanzar una excepción cuando no se encuentran datos.");
    }
}
