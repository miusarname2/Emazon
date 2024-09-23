package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.application.dto.CarritoRequest;
import com.pragma.Emazon.application.dto.CarritoResponse;
import com.pragma.Emazon.application.dto.UsuarioResponse;
import com.pragma.Emazon.application.mapper.CarritoRequestMapper;
import com.pragma.Emazon.application.mapper.CarritoResponseMapper;
import com.pragma.Emazon.domain.api.ICarritoPortService;
import com.pragma.Emazon.domain.model.Carrito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class CarritoHandlerTest{

    @Mock
    private ICarritoPortService carritoPortService;

    @Mock
    private CarritoRequestMapper carritoRequestMapper;

    @Mock
    private CarritoResponseMapper carritoResponseMapper;

    @Mock
    private UsuarioHandler usuarioHandler;

    @Mock
    private ArticuloHandler articuloHandler;

    @InjectMocks
    private CarritoHandler carritoHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCarrito() {
        // Arrange
        CarritoRequest carritoRequest = new CarritoRequest();
        carritoRequest.setId_usuario(1L);
        carritoRequest.setId_articulo(2L);
        carritoRequest.setCantidad(3.0);

        Carrito carrito = new Carrito();
        carrito.setCantidad(3.0);

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setNombre("Juan");

        ArticuloResponse articuloResponse = new ArticuloResponse();
        articuloResponse.setNombre("Laptop");

        CarritoResponse carritoResponse = new CarritoResponse();
        carritoResponse.setUsuario(usuarioResponse);
        carritoResponse.setArticulo(articuloResponse);
        carritoResponse.setCantidad(3.0);

        when(carritoRequestMapper.toCarrito(carritoRequest)).thenReturn(carrito);
        when(carritoPortService.saveCarrito(carrito)).thenReturn(carrito);
        when(usuarioHandler.obtenerUsuarioPorId(1L)).thenReturn(usuarioResponse);
        when(articuloHandler.obtenerArticuloPorId(2L)).thenReturn(articuloResponse);
        when(carritoResponseMapper.toResponse(carrito, usuarioResponse, articuloResponse)).thenReturn(carritoResponse);

        // Act
        CarritoResponse response = carritoHandler.saveCarrito(carritoRequest);

        // Assert
        assertEquals(carritoResponse, response);
        verify(carritoRequestMapper).toCarrito(carritoRequest);
        verify(carritoPortService).saveCarrito(carrito);
        verify(usuarioHandler).obtenerUsuarioPorId(1L);
        verify(articuloHandler).obtenerArticuloPorId(2L);
        verify(carritoResponseMapper).toResponse(carrito, usuarioResponse, articuloResponse);
    }

    @Test
    void updatCarrito() {
        // Arrange
        CarritoRequest carritoRequest = new CarritoRequest();
        carritoRequest.setId_usuario(1L);
        carritoRequest.setId_articulo(2L);
        carritoRequest.setCantidad(5.0);

        Carrito carrito = new Carrito();
        carrito.setCantidad(5.0);

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setNombre("Ana");

        ArticuloResponse articuloResponse = new ArticuloResponse();
        articuloResponse.setNombre("Teléfono");

        CarritoResponse carritoResponse = new CarritoResponse();
        carritoResponse.setUsuario(usuarioResponse);
        carritoResponse.setArticulo(articuloResponse);
        carritoResponse.setCantidad(5.0);

        when(carritoRequestMapper.toCarrito(carritoRequest)).thenReturn(carrito);
        when(carritoPortService.updatCarrito(carrito)).thenReturn(carrito);
        when(usuarioHandler.obtenerUsuarioPorId(1L)).thenReturn(usuarioResponse);
        when(articuloHandler.obtenerArticuloPorId(2L)).thenReturn(articuloResponse);
        when(carritoResponseMapper.toResponse(carrito, usuarioResponse, articuloResponse)).thenReturn(carritoResponse);

        // Act
        CarritoResponse response = carritoHandler.updatCarrito(carritoRequest);

        // Assert
        assertEquals(carritoResponse, response);
        verify(carritoRequestMapper).toCarrito(carritoRequest);
        verify(carritoPortService).updatCarrito(carrito);
        verify(usuarioHandler).obtenerUsuarioPorId(1L);
        verify(articuloHandler).obtenerArticuloPorId(2L);
        verify(carritoResponseMapper).toResponse(carrito, usuarioResponse, articuloResponse);
    }

}