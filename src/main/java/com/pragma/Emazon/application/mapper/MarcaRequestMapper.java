package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.CategoriaRequest;
import com.pragma.Emazon.application.dto.MarcaRequest;
import com.pragma.Emazon.domain.model.Marca;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface MarcaRequestMapper {

    Marca toMarca(MarcaRequest marcaRequest);

}
