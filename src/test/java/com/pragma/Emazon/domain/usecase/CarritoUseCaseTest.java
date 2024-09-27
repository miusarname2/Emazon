package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.model.Carrito;
import com.pragma.Emazon.domain.spi.ICarritoPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void deleteCarrito() {
        // Arrange
        Carrito carrito = new Carrito();
        carrito.setId(1L);

        // Mock the behavior of carritoPersistence
        when(carritoPersistence.deleteCarrito(carrito)).thenReturn(carrito);

        // Act
        Carrito result = carritoUseCase.deleteCarrito(carrito);

        // Assert
        verify(carritoPersistence).deleteCarrito(carrito);
        assertEquals(carrito, result);
    }

    @Test
    void getAllCarrito() {
        // Arrange
        String sortBy = "id";
        boolean ascending = true;
        int page = 0;
        int size = 10;
        Long id = 1L;

        List<Carrito> expectedCarritoList = new ArrayList<>();
        Carrito carrito1 = new Carrito();
        carrito1.setId(1L);
        carrito1.setCantidad(50.0);

        Carrito carrito2 = new Carrito();
        carrito2.setId(2L);
        carrito2.setCantidad(25.0);

        expectedCarritoList.add(carrito1);
        expectedCarritoList.add(carrito2);

        // Mock the behavior of carritoPersistence
        when(carritoPersistence.GetAllCarrito(sortBy, ascending, page, size, id)).thenReturn(expectedCarritoList);

        // Act
        List<Carrito> result = carritoUseCase.GetAllCarrito(sortBy, ascending, page, size, id);

        // Assert
        verify(carritoPersistence).GetAllCarrito(sortBy, ascending, page, size, id);
        assertEquals(expectedCarritoList, result);
    }


}