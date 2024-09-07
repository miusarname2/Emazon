package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.TipoDocumento;
import com.pragma.Emazon.infrastructure.output.jpa.entity.TipoDocumentoEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.TipoDocumentoEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ITipoDocumentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TipoDocumentoJpaAdapterTest {

    @Mock
    private ITipoDocumentoRepository tipoDocumentoRepository;

    @Mock
    private TipoDocumentoEntityMapper tipoDocumentoEntityMapper;

    @InjectMocks
    private TipoDocumentoJpaAdapter tipoDocumentoJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerTipoDocumento_whenTipoDocumentoExists_returnsTipoDocumento() {
        // Arrange
        Long tipoDocumentoId = 1L;

        TipoDocumentoEntity tipoDocumentoEntity = new TipoDocumentoEntity();
        tipoDocumentoEntity.setId(tipoDocumentoId);
        tipoDocumentoEntity.setNombre("DNI");

        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setId(tipoDocumentoId);
        tipoDocumento.setNombre("DNI");

        when(tipoDocumentoRepository.getById(tipoDocumentoId)).thenReturn(tipoDocumentoEntity);
        when(tipoDocumentoEntityMapper.toTipoDocumento(tipoDocumentoEntity)).thenReturn(tipoDocumento);

        // Act
        TipoDocumento result = tipoDocumentoJpaAdapter.obtenerTipoDocumento(tipoDocumentoId);

        // Assert
        assertEquals(tipoDocumento, result, "El tipo de documento devuelto debería ser igual al esperado.");
        verify(tipoDocumentoRepository).getById(tipoDocumentoId);
        verify(tipoDocumentoEntityMapper).toTipoDocumento(tipoDocumentoEntity);
    }

}