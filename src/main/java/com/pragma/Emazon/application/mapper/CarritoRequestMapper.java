package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.CarritoRequest;
import com.pragma.Emazon.domain.model.Carrito;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CarritoRequestMapper {

    Carrito toCarrito(CarritoRequest carritoRequest);

}
