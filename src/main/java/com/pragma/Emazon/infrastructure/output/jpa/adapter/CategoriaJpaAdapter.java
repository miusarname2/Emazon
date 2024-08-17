package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.spi.ICategoriaPersistence;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ICategoriaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoriaJpaAdapter implements ICategoriaPersistence {

    private final ICategoriaRepository categoriaRepository;

    private final CategoriaEntityMapper categoriaEntityMapper;

    @Override
    public void saveCategoria(Categoria categoria) {
        categoriaRepository.save(categoriaEntityMapper.toEntity(categoria));
    }
}
