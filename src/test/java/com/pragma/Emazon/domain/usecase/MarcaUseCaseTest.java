package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.model.Marca;
import com.pragma.Emazon.domain.spi.IMarcaPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MarcaUseCaseTest {

    @Mock
    private IMarcaPersistence marcaPersistence;

    @InjectMocks
    private MarcaUseCase marcaUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveMarca() {
        // Arrange
        Marca marca = new Marca();
        marca.setNombre("Electrónica");
        marca.setDescripcion("Productos electrónicos");

        when(marcaPersistence.saveMarca(marca)).thenReturn(marca);

        // Act
        Marca savedMarca = marcaUseCase.saveMarca(marca);

        // Assert
        assertEquals(marca, savedMarca, "El objeto marca guardado debería ser igual al esperado.");
        verify(marcaPersistence).saveMarca(marca);
    }

    @Test
    void listMarca() {
        // Arrange
        Marca marca1 = new Marca();
        marca1.setNombre("Electrónica");
        marca1.setDescripcion("Productos electrónicos");

        Marca marca2 = new Marca();
        marca2.setNombre("Hogar");
        marca2.setDescripcion("Productos para el hogar");

        List<Marca> marcas = Arrays.asList(marca1, marca2);

        when(marcaPersistence.listMarca()).thenReturn(marcas);

        // Act
        List<Marca> result = marcaUseCase.listMarca();

        // Assert
        assertEquals(marcas, result, "La lista de marcas debería ser igual a la esperada.");
        verify(marcaPersistence).listMarca();
    }

}