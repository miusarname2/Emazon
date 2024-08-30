package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.infrastructure.output.jpa.entity.ArticuloEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ArticuloEntityMapper {

    ArticuloEntity toEntity(Articulo articulo);

    Articulo toArticulo(ArticuloEntity articuloEntity);

}
