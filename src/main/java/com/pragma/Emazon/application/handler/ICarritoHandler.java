package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.CarritoRequest;
import com.pragma.Emazon.application.dto.CarritoResponse;
import com.pragma.Emazon.domain.model.Carrito;

public interface ICarritoHandler {

    CarritoResponse saveCarrito(CarritoRequest carrito);

    CarritoResponse updatCarrito(CarritoRequest carrito);

    CarritoResponse deleteCarrito(CarritoRequest carrito);

}
