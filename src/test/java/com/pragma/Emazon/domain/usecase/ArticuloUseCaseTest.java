package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.domain.spi.IArticuloPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

class ArticuloUseCaseTest {

    @Mock
    private IArticuloPersistence articuloPersistence;

    @InjectMocks
    private ArticuloUseCase articuloUseCase;

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

        // Mock the behavior of articuloPersistence
        when(articuloPersistence.saveArticulo(articulo)).thenReturn(articulo);

        // Act
        Articulo result = articuloUseCase.saveArticulo(articulo);

        // Assert
        verify(articuloPersistence).saveArticulo(articulo);
        assertEquals(articulo, result);
    }

}