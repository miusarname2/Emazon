package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Marca;
import com.pragma.Emazon.domain.spi.IMarcaPersistence;
import com.pragma.Emazon.infrastructure.exceptions.NoDataFound;
import com.pragma.Emazon.infrastructure.output.jpa.entity.MarcaEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.MarcaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IMarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class MarcaJpaAdapter implements IMarcaPersistence {

    private final IMarcaRepository marcaRepository;
    private final MarcaEntityMapper marcaEntityMapper;

    @Override
    public Marca saveMarca(Marca marca) {
        if (marcaRepository.existsByNombre(marca.getNombre())){
            throw new IllegalArgumentException("Ya existe en la base de datos una marca con ese nombre.");
        }
        return marcaEntityMapper.toMarca(marcaRepository.save(marcaEntityMapper.toEntity(marca)));
    }

    @Override
    public List<Marca> listMarca(String sortBy, boolean ascending,int page, int size) {
        Sort sort = Sort.by(Sort.Direction.fromString(ascending ? "ASC" : "DESC"), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        List<MarcaEntity> marcaEntities = marcaRepository.findAll(pageable).getContent();
        if (marcaEntities.isEmpty()){
            throw new NoDataFound();
        }
        return marcaEntityMapper.toMarcaList(marcaEntities);
    }

    @Override
    public Marca obtenerMarca(Long id) {
        return marcaEntityMapper.toMarca(marcaRepository.getById(id));
    }
}
