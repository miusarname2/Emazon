package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.model.Carrito;
import com.pragma.Emazon.domain.spi.ICarritoPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarritoUseCaseTest {

    @Mock
    private ICarritoPersistence carritoPersistence;

    @InjectMocks
    private CarritoUseCase carritoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCarrito() {
        // Arrange
        Carrito carrito = new Carrito();
        carrito.setId(1L);
        carrito.setCantidad(100.0);

        // Mock the behavior of carritoPersistence
        when(carritoPersistence.saveCarrito(carrito)).thenReturn(carrito);

        // Act
        Carrito result = carritoUseCase.saveCarrito(carrito);

        // Assert
        verify(carritoPersistence).saveCarrito(carrito);
        assertEquals(carrito, result);
    }

    @Test
    void updateCarrito() {
        // Arrange
        Carrito carrito = new Carrito();
        carrito.setId(1L);
        carrito.setCantidad(150.0);

        // Mock the behavior of carritoPersistence
        when(carritoPersistence.updatCarrito(carrito)).thenReturn(carrito);

        // Act
        Carrito result = carritoUseCase.updatCarrito(carrito);

        // Assert
        verify(carritoPersistence).updatCarrito(carrito);
        assertEquals(carrito, result);
    }

}