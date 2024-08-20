package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.CategoriaRequest;
import com.pragma.Emazon.application.dto.CategoriaResponse;
import com.pragma.Emazon.domain.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CategoriaResponseMapper {

    CategoriaResponse toResponse(Categoria categoria);

    default List<CategoriaResponse> toResponseList(List<Categoria> categorias){
        return categorias.stream()
                .map(categoria -> {
                    CategoriaResponse categoriaResponse = new CategoriaResponse();
                    categoriaResponse.setNombre(categoria.getNombre());
                    categoriaResponse.setDescripcion(categoria.getDescripcion());
                    return categoriaResponse;
                }).toList();
    }

}
