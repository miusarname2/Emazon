package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.TipoDocumentoResponse;
import com.pragma.Emazon.domain.model.TipoDocumento;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "Spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TipoDocumentoResponseMapper {

    TipoDocumentoResponse toResponse(TipoDocumento tipoDocumento);

}
