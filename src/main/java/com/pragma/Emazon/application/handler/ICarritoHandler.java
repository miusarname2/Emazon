package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.CarritoListResponse;
import com.pragma.Emazon.application.dto.CarritoRequest;
import com.pragma.Emazon.application.dto.CarritoResponse;
import com.pragma.Emazon.domain.model.Carrito;

import java.util.List;

public interface ICarritoHandler {

    CarritoResponse saveCarrito(CarritoRequest carrito);

    CarritoResponse updatCarrito(CarritoRequest carrito);

    CarritoResponse deleteCarrito(CarritoRequest carrito);

   CarritoListResponse GetAllCarrito(String sortBy, boolean ascending, int page, int size, Long id);

}
