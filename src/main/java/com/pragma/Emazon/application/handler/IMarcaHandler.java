package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.MarcaRequest;
import com.pragma.Emazon.application.dto.MarcaResponse;
import com.pragma.Emazon.domain.model.Marca;

import java.util.List;

public interface IMarcaHandler {

    MarcaResponse saveMarca(MarcaRequest marcaRequest);

    List<MarcaResponse> listMarca(String sortBy, boolean ascending,int page, int size);

    Marca obtenerMarca(Long id);

}
