package com.pragma.Emazon.domain.spi;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.model.Marca;

public interface IMarcaPersistence {

    Marca saveMarca(Marca marca);

}
