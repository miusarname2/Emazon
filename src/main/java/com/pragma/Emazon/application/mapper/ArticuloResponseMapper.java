package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.application.dto.CategoriaResponse;
import com.pragma.Emazon.application.dto.MarcaResponse;
import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.model.Marca;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = {CategoriaResponseMapper.class,MarcaResponseMapper.class}
)
public interface ArticuloResponseMapper {

    default ArticuloResponse toResponse(Articulo articulo, CategoriaResponse categoria, MarcaResponse marca){
        ArticuloResponse articuloResponse = new ArticuloResponse();
        articuloResponse.setCantidad(articulo.getCantidad());
        articuloResponse.setId(articulo.getId());
        articuloResponse.setCategoria(categoria);
        articuloResponse.setMarca(marca);
        articuloResponse.setNombre(articulo.getNombre());
        articuloResponse.setDescripcion(articulo.getDescripcion());
        articuloResponse.setPrecio(articulo.getPrecio());
        return articuloResponse;
    }

}
