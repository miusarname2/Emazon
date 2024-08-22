package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.infrastructure.output.jpa.entity.ArticuloEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.ArticuloEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IArticuloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArticuloJpaAdapterTest {

    @Mock
    private IArticuloRepository articuloRepository;

    @Mock
    private ArticuloEntityMapper articuloEntityMapper;

    @InjectMocks
    private ArticuloJpaAdapter articuloJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveArticulo() {
        // Arrange
        Articulo articulo = new Articulo();
        articulo.setId(1L);
        articulo.setCantidad(10);
        articulo.setPrecio(99.99);
        articulo.setIdCategoria(2L);
        articulo.setIdMarca(3L);

        ArticuloEntity articuloEntity = new ArticuloEntity();
        articuloEntity.setId(1L);
        articuloEntity.setCantidad(10);
        articuloEntity.setPrecio(99.99);
        articuloEntity.setIdCategoria(2L);
        articuloEntity.setIdMarca(3L);

        when(articuloEntityMapper.toEntity(articulo)).thenReturn(articuloEntity);
        when(articuloRepository.save(articuloEntity)).thenReturn(articuloEntity);
        when(articuloEntityMapper.toArticulo(articuloEntity)).thenReturn(articulo);

        // Act
        Articulo result = articuloJpaAdapter.saveArticulo(articulo);

        // Assert
        verify(articuloEntityMapper).toEntity(articulo);
        verify(articuloRepository).save(articuloEntity);
        verify(articuloEntityMapper).toArticulo(articuloEntity);
        assertEquals(articulo, result);
    }

}