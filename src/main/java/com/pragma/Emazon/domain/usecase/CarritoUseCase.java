package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.api.ICarritoPortService;
import com.pragma.Emazon.domain.model.Carrito;
import com.pragma.Emazon.domain.spi.ICarritoPersistence;

public class CarritoUseCase implements ICarritoPortService {

    private final ICarritoPersistence carritoPersistence;

    public CarritoUseCase(ICarritoPersistence carritoPersistence) {
        this.carritoPersistence = carritoPersistence;
    }

    @Override
    public Carrito saveCarrito(Carrito carrito) {
        return carritoPersistence.saveCarrito(carrito);
    }

    @Override
    public Carrito updatCarrito(Carrito carrito) {
        return carritoPersistence.updatCarrito(carrito);
    }

    @Override
    public Carrito deleteCarrito(Carrito carrito) {
        return carritoPersistence.deleteCarrito(carrito);
    }
}
