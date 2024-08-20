package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.ArticuloRequest;
import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.domain.model.Articulo;

public interface IArticuloHandler {

    ArticuloResponse saveArticulo(ArticuloRequest articuloRequest);

}
