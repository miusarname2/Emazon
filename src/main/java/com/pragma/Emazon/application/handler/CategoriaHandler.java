package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.CategoriaRequest;
import com.pragma.Emazon.application.dto.CategoriaResponse;
import com.pragma.Emazon.application.mapper.CategoriaRequestMapper;
import com.pragma.Emazon.application.mapper.CategoriaResponseMapper;
import com.pragma.Emazon.domain.api.ICategoriaPortService;
import com.pragma.Emazon.domain.model.Categoria;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoriaHandler implements ICategoriaHandler{

    private final ICategoriaPortService categoriaPortService;
    private final CategoriaRequestMapper categoriaRequestMapper;
    private final CategoriaResponseMapper categoriaResponseMapper;

    @Override
    public void saveCategoria(CategoriaRequest categoriaRequest) {
         categoriaPortService.saveCategoria(categoriaRequestMapper.toCategoria(categoriaRequest));
    }

    @Override
    public List<CategoriaResponse> listCategoria() {
        return categoriaResponseMapper.toResponseList(categoriaPortService.listCategorias());
    }

    @Override
    public Categoria obtenerCategoria(Long id) {
        return categoriaPortService.obtenerCategoria(id);
    }
}
