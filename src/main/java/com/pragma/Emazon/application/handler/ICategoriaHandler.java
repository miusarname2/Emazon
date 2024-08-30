package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.CategoriaRequest;
import com.pragma.Emazon.application.dto.CategoriaResponse;
import com.pragma.Emazon.domain.model.Categoria;

import java.util.List;

public interface ICategoriaHandler {

    void saveCategoria(CategoriaRequest categoriaRequest);

    List<CategoriaResponse> listCategoria(String sortBy, boolean ascending,int page, int size);

    Categoria obtenerCategoria(Long id);

}
