package com.pragma.Emazon.domain.spi;

import com.pragma.Emazon.domain.model.Carrito;

public interface ICarritoPersistence {

    Carrito saveCarrito(Carrito carrito);

    Carrito updatCarrito(Carrito carrito);

}
