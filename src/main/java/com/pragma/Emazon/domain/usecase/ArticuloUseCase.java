package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.api.IArticuloPortService;
import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.domain.spi.IArticuloPersistence;

public class ArticuloUseCase implements IArticuloPortService {

    private final IArticuloPersistence articuloPersistence;

    public ArticuloUseCase(IArticuloPersistence articuloPersistence) {
        this.articuloPersistence = articuloPersistence;
    }

    @Override
    public Articulo saveArticulo(Articulo articulo) {
        return articuloPersistence.saveArticulo(articulo);
    }
}
