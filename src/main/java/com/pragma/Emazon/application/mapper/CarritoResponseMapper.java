package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.application.dto.CarritoResponse;
import com.pragma.Emazon.application.dto.UsuarioResponse;
import com.pragma.Emazon.domain.model.Carrito;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CarritoResponseMapper {

    default CarritoResponse toResponse(Carrito carrito, UsuarioResponse usuarioResponse, ArticuloResponse articuloResponse){
        return getCarritoResponse(carrito, usuarioResponse, articuloResponse);
    }

    private static CarritoResponse getCarritoResponse(Carrito carrito, UsuarioResponse usuarioResponse, ArticuloResponse articuloResponse) {
        CarritoResponse response = new CarritoResponse();
        response.setArticulo(articuloResponse);
        response.setUsuario(usuarioResponse);
        response.setCantidad(carrito.getCantidad());
        return response;
    }

}
