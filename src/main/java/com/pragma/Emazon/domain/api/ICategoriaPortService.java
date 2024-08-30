package com.pragma.Emazon.domain.api;

import com.pragma.Emazon.domain.model.Categoria;

import java.util.List;

public interface ICategoriaPortService {

    void saveCategoria(Categoria categoria);

    List<Categoria> listCategorias(String sortBy, boolean ascending,int page, int size);

    Categoria obtenerCategoria(Long id);

}
