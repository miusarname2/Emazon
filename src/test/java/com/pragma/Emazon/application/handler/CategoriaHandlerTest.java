package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.CategoriaRequest;
<<<<<<< HEAD
import com.pragma.Emazon.application.dto.CategoriaResponse;
import com.pragma.Emazon.application.mapper.CategoriaRequestMapper;
import com.pragma.Emazon.application.mapper.CategoriaResponseMapper;
=======
import com.pragma.Emazon.application.mapper.CategoriaRequestMapper;
>>>>>>> feature/H06
import com.pragma.Emazon.domain.api.ICategoriaPortService;
import com.pragma.Emazon.domain.model.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.List;

=======
>>>>>>> feature/H06
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CategoriaHandlerTest {

    @Mock
    private ICategoriaPortService categoriaPortService;

    @Mock
    private CategoriaRequestMapper categoriaRequestMapper;

<<<<<<< HEAD
    @Mock
    private CategoriaResponseMapper categoriaResponseMapper;

=======
>>>>>>> feature/H06
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

    @Test
    void listCategoria() {
        // Arrange
        Categoria categoria1 = new Categoria();
        categoria1.setNombre("Electrónica");
        categoria1.setDescripcion("Productos electrónicos");

        Categoria categoria2 = new Categoria();
        categoria2.setNombre("Hogar");
        categoria2.setDescripcion("Productos para el hogar");

        List<Categoria> categorias = Arrays.asList(categoria1, categoria2);

        CategoriaResponse categoriaResponse1 = new CategoriaResponse();
        categoriaResponse1.setNombre("Electrónica");
        categoriaResponse1.setDescripcion("Productos electrónicos");

        CategoriaResponse categoriaResponse2 = new CategoriaResponse();
        categoriaResponse2.setNombre("Hogar");
        categoriaResponse2.setDescripcion("Productos para el hogar");

        List<CategoriaResponse> categoriaResponses = Arrays.asList(categoriaResponse1, categoriaResponse2);

        when(categoriaPortService.listCategorias("nombre", true, 0, 10)).thenReturn(categorias);
        when(categoriaResponseMapper.toResponseList(categorias)).thenReturn(categoriaResponses);

        // Act
        List<CategoriaResponse> result = categoriaHandler.listCategoria("nombre", true, 0, 10);

        // Assert
        verify(categoriaPortService).listCategorias("nombre", true, 0, 10);
        verify(categoriaResponseMapper).toResponseList(categorias);
        assertEquals(categoriaResponses, result);
    }


}