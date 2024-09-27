package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Carrito;
import com.pragma.Emazon.infrastructure.output.jpa.entity.CarritoEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.CarritoEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ICarritoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarritoJpaAdapterTest {

    @Mock
    private ICarritoRepository carritoRepository;

    @Mock
    private CarritoEntityMapper carritoEntityMapper;

    @InjectMocks
    private CarritoJpaAdapter carritoJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCarrito_whenCarritoExists_updatesCarrito() {
        // Arrange
        Carrito carrito = new Carrito();
        carrito.setId_articulo(1L);
        carrito.setId_usuario(1L);
        carrito.setCantidad(5);

        CarritoEntity carritoEntityExistente = new CarritoEntity();
        carritoEntityExistente.setCantidad(3);  // Cantidad previa

        when(carritoRepository.findByIdArticuloAndIdUsuario(1L, 1L)).thenReturn(Optional.of(carritoEntityExistente));
        when(carritoRepository.save(carritoEntityExistente)).thenReturn(carritoEntityExistente);
        when(carritoEntityMapper.toCarrito(carritoEntityExistente)).thenReturn(carrito);

        // Act
        Carrito result = carritoJpaAdapter.saveCarrito(carrito);

        // Assert
        assertEquals(5, carritoEntityExistente.getCantidad());  // Verifica que la cantidad ha sido actualizada
        verify(carritoRepository).save(carritoEntityExistente);
        assertEquals(carrito, result);
    }

    @Test
    void saveCarrito_whenCarritoDoesNotExist_createsNewCarrito() {
        // Arrange
        Carrito carrito = new Carrito();
        carrito.setId_articulo(1L);
        carrito.setId_usuario(2L);
        carrito.setCantidad(10);

        CarritoEntity carritoEntityNuevo = new CarritoEntity();

        when(carritoRepository.findByIdArticuloAndIdUsuario(1L, 2L)).thenReturn(Optional.empty());
        when(carritoEntityMapper.toEntity(carrito)).thenReturn(carritoEntityNuevo);
        when(carritoRepository.save(carritoEntityNuevo)).thenReturn(carritoEntityNuevo);
        when(carritoEntityMapper.toCarrito(carritoEntityNuevo)).thenReturn(carrito);

        // Act
        Carrito result = carritoJpaAdapter.saveCarrito(carrito);

        // Assert
        verify(carritoRepository).save(carritoEntityNuevo);
        assertEquals(carrito, result);
    }

    @Test
    void updateCarrito_whenCarritoExists_updatesCarrito() {
        // Arrange
        Carrito carrito = new Carrito();
        carrito.setId_articulo(1L);
        carrito.setId_usuario(1L);
        carrito.setCantidad(8);

        CarritoEntity carritoEntityExistente = new CarritoEntity();
        carritoEntityExistente.setCantidad(4);  // Cantidad previa

        when(carritoRepository.findByIdArticuloAndIdUsuario(1L, 1L)).thenReturn(Optional.of(carritoEntityExistente));
        when(carritoRepository.save(carritoEntityExistente)).thenReturn(carritoEntityExistente);
        when(carritoEntityMapper.toCarrito(carritoEntityExistente)).thenReturn(carrito);

        // Act
        Carrito result = carritoJpaAdapter.updatCarrito(carrito);

        // Assert
        assertEquals(8, carritoEntityExistente.getCantidad());  // Verifica que la cantidad ha sido actualizada
        verify(carritoRepository).save(carritoEntityExistente);
        assertEquals(carrito, result);
    }

    @Test
    void updateCarrito_whenCarritoDoesNotExist_createsNewCarrito() {
        // Arrange
        Carrito carrito = new Carrito();
        carrito.setId_articulo(2L);
        carrito.setId_usuario(3L);
        carrito.setCantidad(15);

        CarritoEntity carritoEntityNuevo = new CarritoEntity();

        when(carritoRepository.findByIdArticuloAndIdUsuario(2L, 3L)).thenReturn(Optional.empty());
        when(carritoEntityMapper.toEntity(carrito)).thenReturn(carritoEntityNuevo);
        when(carritoRepository.save(carritoEntityNuevo)).thenReturn(carritoEntityNuevo);
        when(carritoEntityMapper.toCarrito(carritoEntityNuevo)).thenReturn(carrito);

        // Act
        Carrito result = carritoJpaAdapter.updatCarrito(carrito);

        // Assert
        verify(carritoRepository).save(carritoEntityNuevo);
        assertEquals(carrito, result);
    }

    @Test
    void deleteCarrito_whenCarritoExists_deletesCarrito() {
        // Arrange
        Carrito carrito = new Carrito();
        carrito.setId_articulo(1L);
        carrito.setId_usuario(1L);

        CarritoEntity carritoEntityExistente = new CarritoEntity();

        when(carritoRepository.findByIdArticuloAndIdUsuario(1L, 1L)).thenReturn(Optional.of(carritoEntityExistente));
        when(carritoEntityMapper.toCarrito(carritoEntityExistente)).thenReturn(carrito);

        // Act
        Carrito result = carritoJpaAdapter.deleteCarrito(carrito);

        // Assert
        verify(carritoRepository).delete(carritoEntityExistente);
        assertEquals(carrito, result);
    }

    @Test
    void deleteCarrito_whenCarritoDoesNotExist_throwsException() {
        // Arrange
        Carrito carrito = new Carrito();
        carrito.setId_articulo(2L);
        carrito.setId_usuario(3L);

        when(carritoRepository.findByIdArticuloAndIdUsuario(2L, 3L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> carritoJpaAdapter.deleteCarrito(carrito));
    }

    @Test
    void getAllCarrito_returnsSortedAndPagedList() {
        // Arrange
        String sortBy = "id";
        boolean ascending = true;
        int page = 0;
        int size = 10;
        Long idUsuario = 1L;

        CarritoEntity carritoEntity1 = new CarritoEntity();
        carritoEntity1.setId(1L);
        carritoEntity1.setCantidad(5);

        CarritoEntity carritoEntity2 = new CarritoEntity();
        carritoEntity2.setId(2L);
        carritoEntity2.setCantidad(10);

        List<CarritoEntity> carritoEntities = Arrays.asList(carritoEntity1, carritoEntity2);

        Page<CarritoEntity> carritoPage = new PageImpl<>(carritoEntities);

        when(carritoRepository.findByIdUsuario(eq(idUsuario), any(Pageable.class))).thenReturn(carritoPage);
        Carrito carrito1 = new Carrito();
        Carrito carrito2 = new Carrito();
        when(carritoEntityMapper.toCarrito(carritoEntity1)).thenReturn(carrito1);
        when(carritoEntityMapper.toCarrito(carritoEntity2)).thenReturn(carrito2);
        carrito1.setCantidad(1L);
        carrito2.setCantidad(2L);

        // Act
        List<Carrito> result = carritoJpaAdapter.GetAllCarrito(sortBy, ascending, page, size, idUsuario);

        // Assert
        assertEquals(2, result.size());
    }


}