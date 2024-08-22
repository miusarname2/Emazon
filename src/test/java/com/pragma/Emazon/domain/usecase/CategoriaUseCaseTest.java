package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.spi.ICategoriaPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CategoriaUseCaseTest {

    @Mock
    private ICategoriaPersistence categoriaPersistence;

    @InjectMocks
    private CategoriaUseCase categoriaUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCategoria() {
        // Arrange
        Categoria categoria = new Categoria();
        categoria.setNombre("Electrónica");
        categoria.setDescripcion("Productos electrónicos");

        // Act
        categoriaUseCase.saveCategoria(categoria);

        // Assert
        verify(categoriaPersistence).saveCategoria(categoria);
    }

    @Test
    void listCategorias() {
        // Arrange
        Categoria categoria1 = new Categoria();
        categoria1.setNombre("Electrónica");
        categoria1.setDescripcion("Productos electrónicos");

        Categoria categoria2 = new Categoria();
        categoria2.setNombre("Hogar");
        categoria2.setDescripcion("Productos para el hogar");

        List<Categoria> categorias = Arrays.asList(categoria1, categoria2);

        when(categoriaPersistence.listCategorias()).thenReturn(categorias);

        // Act
        List<Categoria> result = categoriaUseCase.listCategorias();

        // Assert
        verify(categoriaPersistence).listCategorias();
        assertEquals(categorias, result);
    }

}