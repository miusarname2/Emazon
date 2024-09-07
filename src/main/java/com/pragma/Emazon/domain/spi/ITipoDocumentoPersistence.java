package com.pragma.Emazon.domain.spi;

import com.pragma.Emazon.domain.model.TipoDocumento;

public interface ITipoDocumentoPersistence {

    TipoDocumento obtenerTipoDocumento(Long id);

}
