package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.api.IMarcaPortService;
import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.model.Marca;
import com.pragma.Emazon.domain.spi.IMarcaPersistence;

import java.util.List;

public class MarcaUseCase implements IMarcaPortService {

    private final IMarcaPersistence marcaPersistence;

    public MarcaUseCase(IMarcaPersistence marcaPersistence) {
        this.marcaPersistence = marcaPersistence;
    }

    @Override
    public Marca saveMarca(Marca marca) {
        return marcaPersistence.saveMarca(marca);
    }

    @Override

    public List<Marca> listMarca(String sortBy, boolean ascending,int page, int size) {
        return marcaPersistence.listMarca(sortBy,ascending,page,size);
    }

    @Override
    public Marca obtenerMarca(Long id) {
        return marcaPersistence.obtenerMarca(id);
    }
}
