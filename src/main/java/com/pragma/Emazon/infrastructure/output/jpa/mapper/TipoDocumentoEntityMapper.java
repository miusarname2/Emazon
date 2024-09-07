package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.TipoDocumento;
import com.pragma.Emazon.infrastructure.output.jpa.entity.TipoDocumentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "Spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TipoDocumentoEntityMapper {

    TipoDocumentoEntity toEntity(TipoDocumento tipoDocumento);

    TipoDocumento toTipoDocumento(TipoDocumentoEntity tipoDocumentoEntity);

}
