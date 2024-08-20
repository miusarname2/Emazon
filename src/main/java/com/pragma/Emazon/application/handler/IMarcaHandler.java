package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.MarcaRequest;
import com.pragma.Emazon.application.dto.MarcaResponse;

public interface IMarcaHandler {

    MarcaResponse saveMarca(MarcaRequest marcaRequest);

}
