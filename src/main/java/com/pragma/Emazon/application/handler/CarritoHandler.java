package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.application.dto.CarritoRequest;
import com.pragma.Emazon.application.dto.CarritoResponse;
import com.pragma.Emazon.application.dto.UsuarioResponse;
import com.pragma.Emazon.application.mapper.CarritoRequestMapper;
import com.pragma.Emazon.application.mapper.CarritoResponseMapper;
import com.pragma.Emazon.application.mapper.UsuarioResponseMapper;
import com.pragma.Emazon.domain.api.ICarritoPortService;
import com.pragma.Emazon.domain.api.IUsuarioPortService;
import com.pragma.Emazon.domain.model.Carrito;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
