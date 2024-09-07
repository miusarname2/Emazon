package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.RolResponse;
import com.pragma.Emazon.domain.model.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "Spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface RolResponseMapper {

    RolResponse toResponse(Rol rol);

}
