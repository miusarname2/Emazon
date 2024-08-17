package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.api.ICategoriaPortService;
import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.spi.ICategoriaPersistence;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoriaUseCase implements ICategoriaPortService {

    private final ICategoriaPersistence categoriaPersistence;

    @Override
    public void saveCategoria(Categoria categoria) {
        this.categoriaPersistence.saveCategoria(categoria);
    }
}
