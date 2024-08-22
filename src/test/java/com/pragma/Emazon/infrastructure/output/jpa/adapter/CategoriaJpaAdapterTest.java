package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.infrastructure.exceptions.NoDataFound;
import com.pragma.Emazon.infrastructure.output.jpa.entity.CategoriaEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ICategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CategoriaJpaAdapterTest {

    @Mock
    private ICategoriaRepository categoriaRepository;

    @Mock
    private CategoriaEntityMapper categoriaEntityMapper;

    @InjectMocks
    private CategoriaJpaAdapter categoriaJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCategoria_whenCategoriaExists_throwsException() {
        // Arrange
        Categoria categoria = new Categoria();
        categoria.setNombre("Electrónica");

        when(categoriaRepository.existsByNombre("Electrónica")).thenReturn(true);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> categoriaJpaAdapter.saveCategoria(categoria));
    }

    @Test
    void saveCategoria_whenCategoriaDoesNotExist_savesCategoria() {
        // Arrange
        Categoria categoria = new Categoria();
        categoria.setNombre("Electrónica");

        CategoriaEntity categoriaEntity = new CategoriaEntity();
        when(categoriaEntityMapper.toEntity(categoria)).thenReturn(categoriaEntity);
        when(categoriaRepository.existsByNombre("Electrónica")).thenReturn(false);

        // Act
        categoriaJpaAdapter.saveCategoria(categoria);

        // Assert
        verify(categoriaRepository).save(categoriaEntity);
    }

    @Test
    void listCategorias_whenDataExists_returnsCategoriaList() {
        // Arrange
        CategoriaEntity categoriaEntity1 = new CategoriaEntity();
        categoriaEntity1.setNombre("Electrónica");

        CategoriaEntity categoriaEntity2 = new CategoriaEntity();
        categoriaEntity2.setNombre("Hogar");

        List<CategoriaEntity> categoriaEntityList = Arrays.asList(categoriaEntity1, categoriaEntity2);

        when(categoriaRepository.findAll()).thenReturn(categoriaEntityList);

        Categoria categoria1 = new Categoria();
        categoria1.setNombre("Electrónica");

        Categoria categoria2 = new Categoria();
        categoria2.setNombre("Hogar");

        when(categoriaEntityMapper.toCategoriaList(categoriaEntityList)).thenReturn(Arrays.asList(categoria1, categoria2));

        // Act
        List<Categoria> result = categoriaJpaAdapter.listCategorias();

        // Assert
        verify(categoriaRepository).findAll();
        assertEquals(2, result.size());
        assertEquals("Electrónica", result.get(0).getNombre());
        assertEquals("Hogar", result.get(1).getNombre());
    }

    @Test
    void listCategorias_whenNoDataFound_throwsNoDataFoundException() {
        // Arrange
        when(categoriaRepository.findAll()).thenReturn(Arrays.asList());

        // Act & Assert
        assertThrows(NoDataFound.class, () -> categoriaJpaAdapter.listCategorias());
    }

}