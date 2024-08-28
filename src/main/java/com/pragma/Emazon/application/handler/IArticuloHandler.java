package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.ArticuloRequest;
import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.domain.model.Articulo;

import java.util.List;

public interface IArticuloHandler {

    ArticuloResponse saveArticulo(ArticuloRequest articuloRequest);

    List<ArticuloResponse> listArticulos();
}
