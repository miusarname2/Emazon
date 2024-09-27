package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Carrito;
import com.pragma.Emazon.domain.spi.ICarritoPersistence;
import com.pragma.Emazon.infrastructure.output.jpa.entity.CarritoEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.CarritoEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ICarritoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public Carrito deleteCarrito(Carrito carrito) {
        Optional<CarritoEntity> carritoOpcional = carritoRepository.findByIdArticuloAndIdUsuario(carrito.getId_articulo(), carrito.getId_usuario());

        if (carritoOpcional.isPresent()) {
            // Carrito encontrado
            CarritoEntity carritoEntity = carritoOpcional.get();
            carritoEntity.setCantidad(carrito.getCantidad());
            carritoRepository.delete(carritoEntity);
            return carritoEntityMapper.toCarrito(carritoEntity);
            // Haz algo con el carrito
        } else {
            throw new EntityNotFoundException("No encontre el Carrito.");
        }
    }

    @Override
    public List<Carrito> GetAllCarrito(String sortBy, boolean ascending, int page, int size, Long id) {
        Sort sort = Sort.by(Sort.Direction.fromString(ascending ? "ASC" : "DESC"), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<CarritoEntity> carritoPage = carritoRepository.findByIdUsuario(id, pageable);
        List<Carrito> carritoList = carritoPage.getContent()
                .stream()
                .map(carritoEntityMapper::toCarrito)
                .collect(Collectors.toList());

        // Retornar la lista de Carrito
        return carritoList;
    }
}
