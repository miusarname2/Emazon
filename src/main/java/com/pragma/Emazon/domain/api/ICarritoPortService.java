package com.pragma.Emazon.domain.api;

import com.pragma.Emazon.domain.model.Carrito;

public interface ICarritoPortService {

    Carrito saveCarrito(Carrito carrito);

    Carrito updatCarrito(Carrito carrito);

    Carrito deleteCarrito(Carrito carrito);

}
