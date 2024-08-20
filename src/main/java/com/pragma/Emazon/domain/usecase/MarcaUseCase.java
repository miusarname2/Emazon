package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.api.IMarcaPortService;
import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.model.Marca;
import com.pragma.Emazon.domain.spi.IMarcaPersistence;

public class MarcaUseCase implements IMarcaPortService {

    private final IMarcaPersistence marcaPersistence;

    public MarcaUseCase(IMarcaPersistence marcaPersistence) {
        this.marcaPersistence = marcaPersistence;
    }

    @Override
    public Marca saveMarca(Marca marca) {
        return marcaPersistence.saveMarca(marca);
    }
}
