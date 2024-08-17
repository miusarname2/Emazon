package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.CategoriaRequest;
import com.pragma.Emazon.domain.model.Categoria;

public interface ICategoriaHandler {

    void saveCategoria(CategoriaRequest categoriaRequest);

}
