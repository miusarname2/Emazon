package com.pragma.Emazon.domain.spi;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.model.Marca;

import java.util.List;

public interface IMarcaPersistence {

    Marca saveMarca(Marca marca);

    List<Marca> listMarca(String sortBy, boolean ascending,int page, int size);

    Marca obtenerMarca(Long id);
}
