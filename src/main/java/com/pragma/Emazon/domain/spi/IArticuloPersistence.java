package com.pragma.Emazon.domain.spi;

import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.infrastructure.output.jpa.entity.ArticuloEntity;

import java.util.List;

public interface IArticuloPersistence {

    Articulo saveArticulo(Articulo articulo);

    List<Articulo> listCategorias(String sortBy, boolean ascending,int page, int size);

    Articulo obtenerArticulo(String articuloNombre);

    Articulo agregarArticuloAlStock(Articulo articulo);

    Articulo obtenerArticuloPorId(Long id);
}
