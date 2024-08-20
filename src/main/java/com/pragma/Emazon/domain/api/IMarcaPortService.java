package com.pragma.Emazon.domain.api;

import com.pragma.Emazon.application.dto.MarcaRequest;
import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.model.Marca;

public interface IMarcaPortService {

    Marca saveMarca(Marca marca);

}
