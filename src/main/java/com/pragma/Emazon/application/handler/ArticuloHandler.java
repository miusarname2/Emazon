package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.ArticuloRequest;
import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.application.mapper.ArticuloRequestMapper;
import com.pragma.Emazon.application.mapper.ArticuloResponseMapper;
import com.pragma.Emazon.domain.api.IArticuloPortService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticuloHandler implements IArticuloHandler{

    private final IArticuloPortService articuloPortService;
    private final ArticuloRequestMapper articuloRequestMapper;
    private final ArticuloResponseMapper articuloResponseMapper;

    @Override
    public ArticuloResponse saveArticulo(ArticuloRequest articuloRequest) {
        return articuloResponseMapper.toResponse(articuloPortService.saveArticulo(articuloRequestMapper.toArticulo(articuloRequest)));
    }
}
