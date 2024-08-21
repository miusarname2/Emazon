package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.infrastructure.output.jpa.entity.CategoriaEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ICategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

}