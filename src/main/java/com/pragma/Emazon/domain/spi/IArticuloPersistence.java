package com.pragma.Emazon.domain.spi;

import com.pragma.Emazon.domain.model.Articulo;

import java.util.List;

public interface IArticuloPersistence {

    Articulo saveArticulo(Articulo articulo);

    List<Articulo> listCategorias(String sortBy, boolean ascending,int page, int size);
}
