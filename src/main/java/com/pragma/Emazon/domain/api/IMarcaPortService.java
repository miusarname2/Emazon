package com.pragma.Emazon.domain.api;

import com.pragma.Emazon.application.dto.MarcaRequest;
import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.model.Marca;

import java.util.List;

public interface IMarcaPortService {

    Marca saveMarca(Marca marca);

    List<Marca> listMarca(String sortBy, boolean ascending,int page, int size);
}
