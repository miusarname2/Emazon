package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.UsuarioRequest;
import com.pragma.Emazon.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UsuarioRequestMapper {

    @Mapping(source = "usuarioRequest.tipoDocumento.id", target = "idTipoDocumento")
    Usuario toUsuario(UsuarioRequest usuarioRequest);

}
