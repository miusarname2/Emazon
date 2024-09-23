package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Articulo;
import com.pragma.Emazon.domain.spi.IArticuloPersistence;
import com.pragma.Emazon.infrastructure.output.jpa.entity.ArticuloEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.ArticuloEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.MarcaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IArticuloRepository;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ICategoriaRepository;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IMarcaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class ArticuloJpaAdapter implements IArticuloPersistence {

    private final IArticuloRepository articuloRepository;
    private final ArticuloEntityMapper articuloEntityMapper;

    @Override
    public Articulo saveArticulo(Articulo articulo) {

        return articuloEntityMapper.toArticulo(articuloRepository.save(articuloEntityMapper.toEntity(articulo)));
    }

    @Override
    public List<Articulo> listCategorias(String sortBy, boolean ascending,int page, int size) {
        Sort sort = Sort.by(Sort.Direction.fromString(ascending ? "ASC" : "DESC"), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return articuloEntityMapper.toArticuloList(articuloRepository.findAll(pageable).getContent());
    }

    @Override
    public Articulo obtenerArticulo(String articuloNombre) {
        ArticuloEntity articulo = articuloRepository.findByNombre(articuloNombre).orElseThrow(()->new EntityNotFoundException("Articulo con nombre " + articuloNombre + " no encontrado"));
        return articuloEntityMapper.toArticulo(articulo);
    }

    @Override
    public Articulo agregarArticuloAlStock(Articulo articulo) {
        return articuloEntityMapper.toArticulo(articuloRepository.save(articuloEntityMapper.toEntity(articulo)));
    }

    @Override
    public Articulo obtenerArticuloPorId(Long id) {
        return articuloEntityMapper.toArticulo(articuloRepository.getById(id));
    }
}
