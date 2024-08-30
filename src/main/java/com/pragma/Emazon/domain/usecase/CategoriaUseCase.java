package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.api.ICategoriaPortService;
import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.spi.ICategoriaPersistence;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoriaUseCase implements ICategoriaPortService {

    private final ICategoriaPersistence categoriaPersistence;

    @Override
    public void saveCategoria(Categoria categoria) {
        this.categoriaPersistence.saveCategoria(categoria);
    }

    @Override
    public List<Categoria> listCategorias(String sortBy, boolean ascending,int page, int size) {
        return categoriaPersistence.listCategorias(sortBy,ascending,page,size);
    }

    @Override
    public Categoria obtenerCategoria(Long id) {
        return categoriaPersistence.obtenerCategoria(id);
    }
}
