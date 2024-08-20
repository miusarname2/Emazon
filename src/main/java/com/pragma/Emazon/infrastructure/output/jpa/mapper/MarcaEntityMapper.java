package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.Marca;
import com.pragma.Emazon.infrastructure.output.jpa.entity.MarcaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MarcaEntityMapper {

    MarcaEntity toEntity(Marca marca);

    Marca toMarca(MarcaEntity marcaEntity);

    List<Marca> toMarcaList(List<MarcaEntity> marcaEntities);

}
