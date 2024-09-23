package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Carrito;
import com.pragma.Emazon.domain.spi.ICarritoPersistence;
import com.pragma.Emazon.infrastructure.output.jpa.entity.CarritoEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.CarritoEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ICarritoRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CarritoJpaAdapter implements ICarritoPersistence {

    private final ICarritoRepository carritoRepository;
    private final CarritoEntityMapper carritoEntityMapper;

    @Override
    public Carrito saveCarrito(Carrito carrito) {
        Optional<CarritoEntity> carritoOpcional = carritoRepository.findByIdArticuloAndIdUsuario(carrito.getId_articulo(), carrito.getId_usuario());

        if (carritoOpcional.isPresent()) {
            // Carrito encontrado
            CarritoEntity carritoEntity = carritoOpcional.get();
            carritoEntity.setCantidad(carrito.getCantidad());
            return carritoEntityMapper.toCarrito(carritoRepository.save(carritoEntity));
            // Haz algo con el carrito
        } else {
            return carritoEntityMapper.toCarrito(carritoRepository.save(carritoEntityMapper.toEntity(carrito)));
        }
    }

    @Override
    public Carrito updatCarrito(Carrito carrito) {
        Optional<CarritoEntity> carritoOpcional = carritoRepository.findByIdArticuloAndIdUsuario(carrito.getId_articulo(), carrito.getId_usuario());

        if (carritoOpcional.isPresent()) {
            // Carrito encontrado
            CarritoEntity carritoEntity = carritoOpcional.get();
            carritoEntity.setCantidad(carrito.getCantidad());
            return carritoEntityMapper.toCarrito(carritoRepository.save(carritoEntity));
            // Haz algo con el carrito
        } else {
            return carritoEntityMapper.toCarrito(carritoRepository.save(carritoEntityMapper.toEntity(carrito)));
        }
    }
}
