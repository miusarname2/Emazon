package com.pragma.Emazon.domain.api;

import com.pragma.Emazon.domain.model.Categoria;

import java.util.List;

public interface ICategoriaPortService {

    void saveCategoria(Categoria categoria);

    List<Categoria> listCategorias();

    Categoria obtenerCategoria(Long id);

}
