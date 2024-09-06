package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.RolResponse;
import com.pragma.Emazon.application.dto.TipoDocumentoResponse;
import com.pragma.Emazon.application.dto.UsuarioResponse;
import com.pragma.Emazon.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UsuarioResponseMapper {

    default UsuarioResponse toResponse(Usuario usuario, RolResponse rolResponse, TipoDocumentoResponse tipoDocumentoResponse){
        UsuarioResponse usuarioResponse = getUsuarioResponse(usuario, rolResponse, tipoDocumentoResponse);
        return usuarioResponse;
    }

    private static UsuarioResponse getUsuarioResponse(Usuario usuario, RolResponse rolResponse, TipoDocumentoResponse tipoDocumentoResponse) {
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setApellido(usuario.getApellido());
        usuarioResponse.setClave("");
        usuarioResponse.setCelular(usuario.getCelular());
        usuarioResponse.setNombre(usuario.getNombre());
        usuarioResponse.setCorreo(usuario.getCorreo());
        usuarioResponse.setDocumento(usuario.getDocumento());
        usuarioResponse.setFecha_nacimiento(usuario.getFecha_nacimiento());
        usuarioResponse.setRol(rolResponse);
        usuarioResponse.setTipoDocumentoResponse(tipoDocumentoResponse);
        return usuarioResponse;
    }

}
