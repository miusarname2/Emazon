package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.ArticuloRequest;
import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.application.dto.CategoriaResponse;
import com.pragma.Emazon.application.dto.MarcaResponse;
import com.pragma.Emazon.application.mapper.ArticuloRequestMapper;
import com.pragma.Emazon.application.mapper.ArticuloResponseMapper;
import com.pragma.Emazon.application.mapper.CategoriaResponseMapper;
import com.pragma.Emazon.application.mapper.MarcaResponseMapper;
import com.pragma.Emazon.domain.api.IArticuloPortService;
import com.pragma.Emazon.domain.api.ICategoriaPortService;
import com.pragma.Emazon.domain.api.IMarcaPortService;
import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.model.Marca;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticuloHandler implements IArticuloHandler{

    private final IArticuloPortService articuloPortService;
    private final ArticuloRequestMapper articuloRequestMapper;
    private final ArticuloResponseMapper articuloResponseMapper;
    private final ICategoriaPortService categoriaPortService;
    private final CategoriaResponseMapper categoriaResponseMapper;
    private final IMarcaPortService marcaPortService;
    private final MarcaResponseMapper marcaResponseMapper;

    @Override
    public ArticuloResponse saveArticulo(ArticuloRequest articuloRequest) {
        MarcaResponse marca = marcaResponseMapper.toResponse(marcaPortService.obtenerMarca(articuloRequest.getMarca().getId()));
        CategoriaResponse categoria = categoriaResponseMapper.toResponse(categoriaPortService.obtenerCategoria(articuloRequest.getCategoria().getId()));
        return articuloResponseMapper.toResponse(articuloPortService.saveArticulo(articuloRequestMapper.toArticulo(articuloRequest)),categoria,marca);
    }

    @Override
    public List<ArticuloResponse> listArticulos() {
        return articuloResponseMapper.toListResponse(articuloPortService.listCategorias(),categoriaPortService.listCategorias(),marcaResponseMapper.toResponseList(marcaPortService.listMarca()));
    }
}
