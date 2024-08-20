package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Marca;
import com.pragma.Emazon.domain.spi.IMarcaPersistence;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.MarcaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IMarcaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MarcaJpaAdapter implements IMarcaPersistence {

    private final IMarcaRepository marcaRepository;
    private final MarcaEntityMapper marcaEntityMapper;

    @Override
    public Marca saveMarca(Marca marca) {
        return marcaEntityMapper.toMarca(marcaRepository.save(marcaEntityMapper.toEntity(marca)));
    }

    @Override
    public List<Marca> listMarca() {
        return marcaEntityMapper.toMarcaList(marcaRepository.findAll());
    }
}
