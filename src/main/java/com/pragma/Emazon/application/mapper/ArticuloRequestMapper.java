package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.ArticuloRequest;
import com.pragma.Emazon.domain.model.Articulo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ArticuloRequestMapper {

    @Mapping(source = "articuloRequest.categoria.id", target = "idCategoria")
    @Mapping(source = "articuloRequest.marca.id",target = "idMarca")
    Articulo toArticulo(ArticuloRequest articuloRequest);

}
