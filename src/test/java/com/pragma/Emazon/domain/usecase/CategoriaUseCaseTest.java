package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.spi.ICategoriaPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

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

}