package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.application.dto.CategoriaResponse;
import com.pragma.Emazon.application.dto.MarcaResponse;
import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.model.Marca;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    default List<ArticuloResponse> toListResponse(List<Articulo> articulos, List<Categoria> categorias, List<MarcaResponse> marcaResponses) {
        return articulos.stream().map(articulo -> {
            ArticuloResponse response = new ArticuloResponse();

            // Encontrar la marca correspondiente
            MarcaResponse marcaResponse = getMarcaResponse(marcaResponses, articulo);

            // Encontrar la categoría correspondiente
            Categoria categoria = categorias.stream()
                    .filter(cat -> cat.getId().equals(articulo.getIdCategoria()))
                    .findFirst().orElse(null);

            // Crear y configurar CategoriaResponse
            CategoriaResponse categoriaResponse = null;
            if (categoria != null) {
                categoriaResponse = new CategoriaResponse();
                categoriaResponse.setNombre(categoria.getNombre());
                categoriaResponse.setDescripcion(categoria.getDescripcion());
            }

            // Configurar ArticuloResponse
            response.setId(articulo.getId());
            response.setNombre(articulo.getNombre());
            response.setDescripcion(articulo.getDescripcion());
            response.setPrecio(articulo.getPrecio());
            response.setCantidad(articulo.getCantidad());
            response.setMarca(marcaResponse);
            response.setCategoria(categoriaResponse);

            return response;
        }).collect(Collectors.toList());
    }

    private static MarcaResponse getMarcaResponse(List<MarcaResponse> marcaResponses, Articulo articulo) {
        return marcaResponses.stream()
                .filter(marca -> marca.getId().equals(articulo.getIdMarca()))
                .findFirst().orElse(null);
    }


}
