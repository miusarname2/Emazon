package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.MarcaResponse;
import com.pragma.Emazon.domain.model.Marca;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface MarcaResponseMapper {

    MarcaResponse toResponse(Marca marca);

    default List<MarcaResponse> toResponseList(List<Marca> marcaList){
        return marcaList
                .stream()
                .map(categoria ->{
                    MarcaResponse response = new MarcaResponse();
                    response.setId(categoria.getId());
                    response.setNombre(categoria.getNombre());
                    response.setDescripcion(categoria.getDescripcion());
                    return response;
                }).toList();
    }

}
