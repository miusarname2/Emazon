package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.api.ITipoDocumentoPortService;
import com.pragma.Emazon.domain.model.TipoDocumento;
import com.pragma.Emazon.domain.spi.ITipoDocumentoPersistence;

public class TipoDocumentoUseCase implements ITipoDocumentoPortService {

    private final ITipoDocumentoPersistence tipoDocumentoPersistence;

    public TipoDocumentoUseCase(ITipoDocumentoPersistence tipoDocumentoPersistence) {
        this.tipoDocumentoPersistence = tipoDocumentoPersistence;
    }

    @Override
    public TipoDocumento obtenerTipoDocumento(Long id) {
        return tipoDocumentoPersistence.obtenerTipoDocumento(id);
    }
}
