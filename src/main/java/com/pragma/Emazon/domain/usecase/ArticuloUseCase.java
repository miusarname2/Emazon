package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.api.IArticuloPortService;
import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.domain.spi.IArticuloPersistence;

import java.util.List;

public class ArticuloUseCase implements IArticuloPortService {

    private final IArticuloPersistence articuloPersistence;

    public ArticuloUseCase(IArticuloPersistence articuloPersistence) {
        this.articuloPersistence = articuloPersistence;
    }

    @Override
    public Articulo saveArticulo(Articulo articulo) {
        return articuloPersistence.saveArticulo(articulo);
    }

    @Override
    public List<Articulo> listArticulos(String sortBy, boolean ascending,int page, int size) {
        return articuloPersistence.listCategorias(sortBy,ascending,page,size);
    }

    @Override
    public Articulo agregarArticuloAlStock(String nombreArticulo, int cantidad) {
        Articulo articulo = articuloPersistence.obtenerArticulo(nombreArticulo);
        articulo.setCantidad(cantidad + articulo.getCantidad());
        return articuloPersistence.agregarArticuloAlStock(articulo);
    }
}
