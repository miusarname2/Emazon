package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.model.TipoDocumento;
import com.pragma.Emazon.domain.spi.ITipoDocumentoPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TipoDocumentoUseCaseTest {

    @Mock
    private ITipoDocumentoPersistence tipoDocumentoPersistence;

    @InjectMocks
    private TipoDocumentoUseCase tipoDocumentoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerTipoDocumento() {
        // Arrange
        Long tipoDocumentoId = 1L;
        TipoDocumento expectedTipoDocumento = new TipoDocumento();
        expectedTipoDocumento.setId(tipoDocumentoId);
        expectedTipoDocumento.setNombre("DNI");
        expectedTipoDocumento.setDescripcion("Documento Nacional de Identidad");

        when(tipoDocumentoPersistence.obtenerTipoDocumento(tipoDocumentoId)).thenReturn(expectedTipoDocumento);

        // Act
        TipoDocumento result = tipoDocumentoUseCase.obtenerTipoDocumento(tipoDocumentoId);

        // Assert
        verify(tipoDocumentoPersistence).obtenerTipoDocumento(tipoDocumentoId);
        assertEquals(expectedTipoDocumento, result, "El tipo de documento devuelto debería ser igual al esperado.");
    }

}