package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.MarcaRequest;
import com.pragma.Emazon.application.dto.MarcaResponse;
import com.pragma.Emazon.application.mapper.MarcaRequestMapper;
import com.pragma.Emazon.application.mapper.MarcaResponseMapper;
import com.pragma.Emazon.domain.api.IMarcaPortService;
import com.pragma.Emazon.domain.model.Marca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MarcaHandlerTest {

    @Mock
    private IMarcaPortService marcaPortService;

    @Mock
    private MarcaRequestMapper marcaRequestMapper;

    @Mock
    private MarcaResponseMapper marcaResponseMapper;

    @InjectMocks
    private MarcaHandler marcaHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveMarca() {
        // Arrange
        MarcaRequest marcaRequest = new MarcaRequest();
        marcaRequest.setNombre("Electrónica");
        marcaRequest.setDescripcion("Productos electrónicos");

        Marca marca = new Marca();
        marca.setNombre("Electrónica");
        marca.setDescripcion("Productos electrónicos");

        MarcaResponse marcaResponse = new MarcaResponse();
        marcaResponse.setNombre("Electrónica");
        marcaResponse.setDescripcion("Productos electrónicos");

        when(marcaRequestMapper.toMarca(marcaRequest)).thenReturn(marca);
        when(marcaPortService.saveMarca(marca)).thenReturn(marca);
        when(marcaResponseMapper.toResponse(marca)).thenReturn(marcaResponse);

        // Act
        MarcaResponse response = marcaHandler.saveMarca(marcaRequest);

        // Assert
        assertEquals(marcaResponse, response);
        verify(marcaRequestMapper).toMarca(marcaRequest);
        verify(marcaPortService).saveMarca(marca);
        verify(marcaResponseMapper).toResponse(marca);
    }

    @Test
    void listMarca() {
        // Arrange
        String sortBy = "nombre";
        boolean ascending = true;
        int page = 0;
        int size = 10;

        Marca marca = new Marca();
        marca.setNombre("Electrónica");
        marca.setDescripcion("Productos electrónicos");

        MarcaResponse marcaResponse = new MarcaResponse();
        marcaResponse.setNombre("Electrónica");
        marcaResponse.setDescripcion("Productos electrónicos");

        when(marcaPortService.listMarca(sortBy, ascending, page, size))
                .thenReturn(Collections.singletonList(marca));
        when(marcaResponseMapper.toResponseList(Collections.singletonList(marca)))
                .thenReturn(Collections.singletonList(marcaResponse));

        // Act
        List<MarcaResponse> responseList = marcaHandler.listMarca(sortBy, ascending, page, size);

        // Assert
        assertEquals(1, responseList.size());
        assertEquals(marcaResponse, responseList.get(0));
        verify(marcaPortService).listMarca(sortBy, ascending, page, size);
        verify(marcaResponseMapper).toResponseList(Collections.singletonList(marca));
    }
}
