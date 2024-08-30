package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.spi.ICategoriaPersistence;
import com.pragma.Emazon.infrastructure.exceptions.NoDataFound;
import com.pragma.Emazon.infrastructure.output.jpa.entity.CategoriaEntity;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.CategoriaEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ICategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
    public List<Categoria> listCategorias(String sortBy, boolean ascending,int page, int size) {
        Sort sort = Sort.by(Sort.Direction.fromString(ascending ? "ASC" : "DESC"), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        List<CategoriaEntity> categoriaList = categoriaRepository.findAll(pageable).getContent();
        if (categoriaList.isEmpty()){
            throw new NoDataFound();
        }
        return categoriaEntityMapper.toCategoriaList(categoriaList);
    }

    @Override
    public Categoria obtenerCategoria(Long id) {
        return categoriaEntityMapper.toCategoria(categoriaRepository.getById(id));
    }
}
