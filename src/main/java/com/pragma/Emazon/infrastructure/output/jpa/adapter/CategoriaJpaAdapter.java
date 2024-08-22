package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.spi.ICategoriaPersistence;
import com.pragma.Emazon.infrastructure.exceptions.NoDataFound;
import com.pragma.Emazon.infrastructure.output.jpa.entity.CategoriaEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ICategoriaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoriaJpaAdapter implements ICategoriaPersistence {

    private final ICategoriaRepository categoriaRepository;

    private final CategoriaEntityMapper categoriaEntityMapper;

    @Override
    public void saveCategoria(Categoria categoria) {
        if (categoriaRepository.existsByNombre(categoria.getNombre())) {
            throw new IllegalArgumentException("Ya existe en la base de datos una categoria con ese nombre.");
        }
        categoriaRepository.save(categoriaEntityMapper.toEntity(categoria));
    }

    @Override
    public List<Categoria> listCategorias() {
        List<CategoriaEntity> categoriaList = categoriaRepository.findAll();
        if (categoriaList.isEmpty()){
            throw new NoDataFound();
        }
        return categoriaEntityMapper.toCategoriaList(categoriaList);
    }
}
