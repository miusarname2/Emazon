package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.domain.spi.IArticuloPersistence;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.ArticuloEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.MarcaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IArticuloRepository;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ICategoriaRepository;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IMarcaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ArticuloJpaAdapter implements IArticuloPersistence {

    private final IArticuloRepository articuloRepository;
    private final ArticuloEntityMapper articuloEntityMapper;
    private final IMarcaRepository marcaRepository;
    private final MarcaEntityMapper marcaEntityMapper;
    private final ICategoriaRepository categoriaRepository;
    private final CategoriaEntityMapper categoriaEntityMapper;

    @Override
    public Articulo saveArticulo(Articulo articulo) {

        return articuloEntityMapper.toArticulo(articuloRepository.save(articuloEntityMapper.toEntity(articulo)));
    }

    @Override
    public List<Articulo> listCategorias() {
        return articuloEntityMapper.toArticuloList(articuloRepository.findAll());
    }
}
