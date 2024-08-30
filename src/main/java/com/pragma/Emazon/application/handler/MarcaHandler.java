package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.MarcaRequest;
import com.pragma.Emazon.application.dto.MarcaResponse;
import com.pragma.Emazon.application.mapper.MarcaRequestMapper;
import com.pragma.Emazon.application.mapper.MarcaResponseMapper;
import com.pragma.Emazon.domain.api.IMarcaPortService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MarcaHandler implements IMarcaHandler{

    private final IMarcaPortService marcaPortService;
    private final MarcaRequestMapper marcaRequestMapper;
    private final MarcaResponseMapper marcaResponseMapper;

    @Override
    public MarcaResponse saveMarca(MarcaRequest marcaRequest) {
        return marcaResponseMapper.toResponse(marcaPortService.saveMarca(marcaRequestMapper.toMarca(marcaRequest)));
    }

    @Override
    public List<MarcaResponse> listMarca(String sortBy, boolean ascending,int page, int size) {
        return marcaResponseMapper.toResponseList(marcaPortService.listMarca(sortBy,ascending,page,size));
    }
}
