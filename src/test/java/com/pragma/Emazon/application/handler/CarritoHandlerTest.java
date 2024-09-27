package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.*;
import com.pragma.Emazon.application.mapper.CarritoRequestMapper;
import com.pragma.Emazon.application.mapper.CarritoResponseMapper;
import com.pragma.Emazon.domain.api.ICarritoPortService;
import com.pragma.Emazon.domain.model.Carrito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void deleteCarrito() {
        // Arrange
        CarritoRequest carritoRequest = new CarritoRequest();
        carritoRequest.setId_usuario(1L);
        carritoRequest.setId_articulo(2L);

        Carrito carrito = new Carrito();

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setNombre("Pedro");

        ArticuloResponse articuloResponse = new ArticuloResponse();
        articuloResponse.setNombre("Televisor");

        CarritoResponse carritoResponse = new CarritoResponse();
        carritoResponse.setUsuario(usuarioResponse);
        carritoResponse.setArticulo(articuloResponse);

        when(carritoRequestMapper.toCarrito(carritoRequest)).thenReturn(carrito);
        when(carritoPortService.deleteCarrito(carrito)).thenReturn(carrito);
        when(usuarioHandler.obtenerUsuarioPorId(1L)).thenReturn(usuarioResponse);
        when(articuloHandler.obtenerArticuloPorId(2L)).thenReturn(articuloResponse);
        when(carritoResponseMapper.toResponse(carrito, usuarioResponse, articuloResponse)).thenReturn(carritoResponse);

        // Act
        CarritoResponse response = carritoHandler.deleteCarrito(carritoRequest);

        // Assert
        assertEquals(carritoResponse, response);
        verify(carritoRequestMapper).toCarrito(carritoRequest);
        verify(carritoPortService).deleteCarrito(carrito);
        verify(usuarioHandler).obtenerUsuarioPorId(1L);
        verify(articuloHandler).obtenerArticuloPorId(2L);
        verify(carritoResponseMapper).toResponse(carrito, usuarioResponse, articuloResponse);
    }

    @Test
    void getAllCarrito() {
        // Arrange
        String sortBy = "nombre";
        boolean ascending = true;
        int page = 0;
        int size = 10;
        Long idUsuario = 1L;

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setNombre("Maria");

        List<Carrito> carritoList = new ArrayList<>();
        Carrito carrito1 = new Carrito();
        carrito1.setId_articulo(1L);
        carrito1.setCantidad(2.0);
        carritoList.add(carrito1);

        Carrito carrito2 = new Carrito();
        carrito2.setId_articulo(2L);
        carrito2.setCantidad(3.0);
        carritoList.add(carrito2);

        ArticuloResponse articuloResponse1 = new ArticuloResponse();
        articuloResponse1.setNombre("Televisor");
        articuloResponse1.setPrecio(200.0);

        ArticuloResponse articuloResponse2 = new ArticuloResponse();
        articuloResponse2.setNombre("Teléfono");
        articuloResponse2.setPrecio(300.0);

        when(usuarioHandler.obtenerUsuarioPorId(idUsuario)).thenReturn(usuarioResponse);
        when(carritoPortService.GetAllCarrito(sortBy, ascending, page, size, idUsuario)).thenReturn(carritoList);
        when(articuloHandler.obtenerArticuloPorId(1L)).thenReturn(articuloResponse1);
        when(articuloHandler.obtenerArticuloPorId(2L)).thenReturn(articuloResponse2);

        // Act
        CarritoListResponse response = carritoHandler.GetAllCarrito(sortBy, ascending, page, size, idUsuario);

        // Assert
        assertEquals(usuarioResponse, response.getUsuario());
        assertEquals(2, response.getCarritoContenido().size());
        assertEquals(1300.0, response.getTotal()); // 2*200 + 3*300
        verify(usuarioHandler).obtenerUsuarioPorId(idUsuario);
        verify(carritoPortService).GetAllCarrito(sortBy, ascending, page, size, idUsuario);
        verify(articuloHandler).obtenerArticuloPorId(1L);
        verify(articuloHandler).obtenerArticuloPorId(2L);
    }


}