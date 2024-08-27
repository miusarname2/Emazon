package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.CategoriaRequest;
import com.pragma.Emazon.application.dto.CategoriaResponse;
import com.pragma.Emazon.domain.model.Categoria;

import java.util.List;

public interface ICategoriaHandler {

    void saveCategoria(CategoriaRequest categoriaRequest);

    List<CategoriaResponse> listCategoria();

    Categoria obtenerCategoria(Long id);

}
