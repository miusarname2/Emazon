package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.Carrito;
import com.pragma.Emazon.infrastructure.output.jpa.entity.CarritoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CarritoEntityMapper {

    CarritoEntity toEntity(Carrito carrito);

    Carrito toCarrito(CarritoEntity carritoEntity);

}
