package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.TipoDocumento;
import com.pragma.Emazon.domain.spi.ITipoDocumentoPersistence;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.TipoDocumentoEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.ITipoDocumentoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TipoDocumentoJpaAdapter implements ITipoDocumentoPersistence {

    private final ITipoDocumentoRepository tipoDocumentoRepository;
    private final TipoDocumentoEntityMapper tipoDocumentoEntityMapper;


    @Override
    public TipoDocumento obtenerTipoDocumento(Long id) {
        return tipoDocumentoEntityMapper.toTipoDocumento(tipoDocumentoRepository.getById(id));
    }
}
