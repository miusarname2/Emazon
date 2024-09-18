package com.pragma.Emazon.domain.api;

import com.pragma.Emazon.domain.model.Articulo;

import java.util.List;

public interface IArticuloPortService {

    Articulo saveArticulo(Articulo articulo);

    List<Articulo> listArticulos(String sortBy, boolean ascending,int page, int size);

    Articulo agregarArticuloAlStock(String nombreArticulo,int cantidad);
}
