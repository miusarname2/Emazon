package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.infrastructure.output.jpa.entity.ArticuloEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ArticuloEntityMapper {

    ArticuloEntity toEntity(Articulo articulo);

    Articulo toArticulo(ArticuloEntity articuloEntity);

    List<Articulo> toArticuloList(List<ArticuloEntity> articuloEntities);

}
