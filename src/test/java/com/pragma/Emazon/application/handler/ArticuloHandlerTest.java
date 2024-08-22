package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.ArticuloRequest;
import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.application.mapper.ArticuloRequestMapper;
import com.pragma.Emazon.application.mapper.ArticuloResponseMapper;
import com.pragma.Emazon.domain.api.IArticuloPortService;
import com.pragma.Emazon.domain.model.Articulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

class ArticuloHandlerTest {

    @Mock
    private IArticuloPortService articuloPortService;

    @Mock
    private ArticuloRequestMapper articuloRequestMapper;

    @Mock
    private ArticuloResponseMapper articuloResponseMapper;

    @InjectMocks
    private ArticuloHandler articuloHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveArticulo() {
        // Arrange
        ArticuloRequest articuloRequest = new ArticuloRequest();
        articuloRequest.setCantidad(10);
        articuloRequest.setPrecio(99.99);
        articuloRequest.setIdCategoria(1L);
        articuloRequest.setIdMarca(2L);

        Articulo articulo = new Articulo();
        articulo.setCantidad(10);
        articulo.setPrecio(99.99);
        articulo.setIdCategoria(1L);
        articulo.setIdMarca(2L);

        ArticuloResponse articuloResponse = new ArticuloResponse();
        articuloResponse.setCantidad(10);
        articuloResponse.setPrecio(99.99);
        articuloResponse.setIdCategoria(1L);
        articuloResponse.setIdMarca(2L);

        when(articuloRequestMapper.toArticulo(articuloRequest)).thenReturn(articulo);
        when(articuloPortService.saveArticulo(articulo)).thenReturn(articulo);
        when(articuloResponseMapper.toResponse(articulo)).thenReturn(articuloResponse);

        // Act
        ArticuloResponse result = articuloHandler.saveArticulo(articuloRequest);

        // Assert
        assertEquals(articuloResponse, result);
        verify(articuloRequestMapper).toArticulo(articuloRequest);
        verify(articuloPortService).saveArticulo(articulo);
        verify(articuloResponseMapper).toResponse(articulo);
    }

}