package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.domain.model.Articulo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ArticuloResponseMapper {

    ArticuloResponse toResponse(Articulo articulo);



}
