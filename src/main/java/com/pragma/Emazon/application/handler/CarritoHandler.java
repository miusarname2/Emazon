package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.*;
import com.pragma.Emazon.application.mapper.CarritoRequestMapper;
import com.pragma.Emazon.application.mapper.CarritoResponseMapper;
import com.pragma.Emazon.application.mapper.UsuarioResponseMapper;
import com.pragma.Emazon.domain.api.ICarritoPortService;
import com.pragma.Emazon.domain.api.IUsuarioPortService;
import com.pragma.Emazon.domain.model.Carrito;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CarritoHandler implements ICarritoHandler {

    private final ICarritoPortService carritoPortService;
    private final CarritoRequestMapper carritoRequestMapper;
    private final CarritoResponseMapper carritoResponseMapper;
    private final UsuarioHandler usuarioHandler;
    private final ArticuloHandler articuloHandler;

    @Override
    public CarritoResponse saveCarrito(CarritoRequest carrito) {
        Carrito carritoActual = carritoPortService.saveCarrito(carritoRequestMapper.toCarrito(carrito));
        UsuarioResponse usuarioResponse = usuarioHandler.obtenerUsuarioPorId(carrito.getId_usuario());
        ArticuloResponse articuloResponse = articuloHandler.obtenerArticuloPorId(carrito.getId_articulo());
        return carritoResponseMapper.toResponse(carritoActual,usuarioResponse,articuloResponse);
    }

    @Override
    public CarritoResponse updatCarrito(CarritoRequest carrito) {
        Carrito carritoActual = carritoPortService.updatCarrito(carritoRequestMapper.toCarrito(carrito));
        UsuarioResponse usuarioResponse = usuarioHandler.obtenerUsuarioPorId(carrito.getId_usuario());
        ArticuloResponse articuloResponse = articuloHandler.obtenerArticuloPorId(carrito.getId_articulo());
        return carritoResponseMapper.toResponse(carritoActual,usuarioResponse,articuloResponse);
    }

    @Override
    public CarritoResponse deleteCarrito(CarritoRequest carrito) {
        UsuarioResponse usuarioResponse = usuarioHandler.obtenerUsuarioPorId(carrito.getId_usuario());
        ArticuloResponse articuloResponse = articuloHandler.obtenerArticuloPorId(carrito.getId_articulo());
        return carritoResponseMapper.toResponse(carritoPortService.deleteCarrito(carritoRequestMapper.toCarrito(carrito)),usuarioResponse,articuloResponse);
    }

    @Override
    public CarritoListResponse GetAllCarrito(String sortBy, boolean ascending, int page, int size, Long id) {
        CarritoListResponse carritoListResponse = new CarritoListResponse();
        UsuarioResponse usuarioResponse = usuarioHandler.obtenerUsuarioPorId(id);

        List<Carrito> carritoList = carritoPortService.GetAllCarrito(sortBy, ascending, page, size, id);
        List<ArticuloResponse> articuloResponses = new ArrayList<>();

        double total = 0; // Usamos una variable simple para el total

        for (Carrito carrito : carritoList) {
            ArticuloResponse articuloResponse = articuloHandler.obtenerArticuloPorId(carrito.getId_articulo());
            articuloResponses.add(articuloResponse);

            double precio = articuloResponse.getPrecio(); // Obtenemos el precio directamente del ArticuloResponse
            total += precio * carrito.getCantidad(); // Calculamos el total
        }

        carritoListResponse.setUsuario(usuarioResponse);
        carritoListResponse.setCarritoContenido(articuloResponses);
        carritoListResponse.setTotal(total);

        return carritoListResponse;

    }

}
