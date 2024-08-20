package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.Marca;
import com.pragma.Emazon.infrastructure.output.jpa.entity.MarcaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MarcaEntityMapper {

    @Mapping(source = "nombre", target = "nombre")
    MarcaEntity toEntity(Marca marca);

    Marca toMarca(MarcaEntity marcaEntity);

}
