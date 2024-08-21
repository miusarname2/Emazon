package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.CategoriaRequest;
import com.pragma.Emazon.application.mapper.CategoriaRequestMapper;
import com.pragma.Emazon.domain.api.ICategoriaPortService;
import com.pragma.Emazon.domain.model.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CategoriaHandlerTest {

    @Mock
    private ICategoriaPortService categoriaPortService;

    @Mock
    private CategoriaRequestMapper categoriaRequestMapper;

    @InjectMocks
    private CategoriaHandler categoriaHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCategoria() {
        // Arrange
        CategoriaRequest categoriaRequest = new CategoriaRequest();
        categoriaRequest.setNombre("Electrónica");
        categoriaRequest.setDescripcion("Productos electrónicos");

        Categoria categoria = new Categoria();
        categoria.setNombre("Electrónica");
        categoria.setDescripcion("Productos electrónicos");

        when(categoriaRequestMapper.toCategoria(categoriaRequest)).thenReturn(categoria);

        // Act
        categoriaHandler.saveCategoria(categoriaRequest);

        // Assert
        verify(categoriaRequestMapper).toCategoria(categoriaRequest);
        verify(categoriaPortService).saveCategoria(categoria);
    }

}