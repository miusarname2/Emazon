package com.pragma.Emazon.infrastructure.output.jpa.mapper;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.infrastructure.output.jpa.entity.CategoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoriaEntityMapper {

    @Mapping(source = "nombre", target = "nombre")
    CategoriaEntity toEntity(Categoria categoria);

    Categoria toCategoria(CategoriaEntity categoriaEntity);

    List<Categoria> toCategoriaList(List<CategoriaEntity> categoriaEntityList);

}
