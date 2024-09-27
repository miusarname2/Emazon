package com.pragma.Emazon.domain.spi;

import com.pragma.Emazon.domain.model.Carrito;

import java.util.List;

public interface ICarritoPersistence {

    Carrito saveCarrito(Carrito carrito);

    Carrito updatCarrito(Carrito carrito);

    Carrito deleteCarrito(Carrito carrito);

    List<Carrito> GetAllCarrito(String sortBy, boolean ascending,int page, int size,Long id);

}
