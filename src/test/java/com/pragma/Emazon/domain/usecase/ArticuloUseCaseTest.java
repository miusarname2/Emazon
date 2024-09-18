package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.domain.spi.IArticuloPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

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

    @Test
    void listArticulos() {
        // Arrange
        Articulo articulo1 = new Articulo();
        articulo1.setId(1L);
        articulo1.setNombre("Articulo 1");
        articulo1.setCantidad(10);
        articulo1.setPrecio(100.0);
        articulo1.setIdCategoria(1L);
        articulo1.setIdMarca(1L);

        Articulo articulo2 = new Articulo();
        articulo2.setId(2L);
        articulo2.setNombre("Articulo 2");
        articulo2.setCantidad(20);
        articulo2.setPrecio(200.0);
        articulo2.setIdCategoria(1L);
        articulo2.setIdMarca(1L);

        List<Articulo> expectedArticulos = Arrays.asList(articulo1, articulo2);

        String sortBy = "nombre";
        boolean ascending = true;
        int page = 0;
        int size = 10;

        // Mock the behavior of articuloPersistence
        when(articuloPersistence.listCategorias(sortBy, ascending, page, size)).thenReturn(expectedArticulos);

        // Act
        List<Articulo> result = articuloUseCase.listArticulos(sortBy, ascending, page, size);

        // Assert
        verify(articuloPersistence).listCategorias(sortBy, ascending, page, size);
        assertEquals(expectedArticulos, result);
    }

    @Test
    void agregarArticuloAlStock() {
        // Arrange
        String nombreArticulo = "Articulo 1";
        int cantidadAAgregar = 5;

        Articulo articuloExistente = new Articulo();
        articuloExistente.setCantidad(10);

        Articulo articuloActualizado = new Articulo();
        articuloActualizado.setCantidad(15); // 10 + 5

        // Mock the behavior of articuloPersistence
        when(articuloPersistence.obtenerArticulo(nombreArticulo)).thenReturn(articuloExistente);
        when(articuloPersistence.agregarArticuloAlStock(articuloExistente)).thenReturn(articuloActualizado);

        // Act
        Articulo result = articuloUseCase.agregarArticuloAlStock(nombreArticulo, cantidadAAgregar);

        // Assert
        verify(articuloPersistence).obtenerArticulo(nombreArticulo);
        verify(articuloPersistence).agregarArticuloAlStock(articuloExistente);
        assertEquals(articuloActualizado, result);
    }
}