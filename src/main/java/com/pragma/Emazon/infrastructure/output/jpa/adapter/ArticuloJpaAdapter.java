package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.domain.spi.IArticuloPersistence;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.ArticuloEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IArticuloRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticuloJpaAdapter implements IArticuloPersistence {

    private final IArticuloRepository articuloRepository;
    private final ArticuloEntityMapper articuloEntityMapper;

    @Override
    public Articulo saveArticulo(Articulo articulo) {
        return articuloEntityMapper.toArticulo(articuloRepository.save(articuloEntityMapper.toEntity(articulo)));
    }
}
