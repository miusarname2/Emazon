package com.pragma.Emazon.domain.spi;

import com.pragma.Emazon.domain.model.Articulo;

public interface IArticuloPersistence {

    Articulo saveArticulo(Articulo articulo);

}
