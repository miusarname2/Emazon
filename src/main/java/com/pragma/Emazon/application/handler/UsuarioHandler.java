package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.RolResponse;
import com.pragma.Emazon.application.dto.TipoDocumentoResponse;
import com.pragma.Emazon.application.dto.UsuarioRequest;
import com.pragma.Emazon.application.dto.UsuarioResponse;
import com.pragma.Emazon.application.mapper.RolResponseMapper;
import com.pragma.Emazon.application.mapper.TipoDocumentoResponseMapper;
import com.pragma.Emazon.application.mapper.UsuarioRequestMapper;
import com.pragma.Emazon.application.mapper.UsuarioResponseMapper;
import com.pragma.Emazon.domain.api.IRolPortService;
import com.pragma.Emazon.domain.api.ITipoDocumentoPortService;
import com.pragma.Emazon.domain.api.IUsuarioPortService;
import com.pragma.Emazon.domain.model.Usuario;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioHandler implements IUsuarioHandler{

    private final IUsuarioPortService usuarioPortService;
    private final UsuarioRequestMapper usuarioRequestMapper;
    private final UsuarioResponseMapper usuarioResponseMapper;
    private final IRolPortService rolPortService;
    private final RolResponseMapper rolResponseMapper;
    private final ITipoDocumentoPortService tipoDocumentoPortService;
    private final TipoDocumentoResponseMapper tipoDocumentoResponseMapper;


    @Override
    public UsuarioResponse saveUsuario(UsuarioRequest usuarioRequest) {
        RolResponse rolResponse = rolResponseMapper.toResponse(rolPortService.obtenerRol(usuarioRequest.getRol().getId()));
        TipoDocumentoResponse tipoDocumentoResponse = tipoDocumentoResponseMapper.toResponse(tipoDocumentoPortService.obtenerTipoDocumento(usuarioRequest.getTipoDocumento().getId()));
        return usuarioResponseMapper.toResponse(usuarioPortService.saveUsuario(usuarioRequestMapper.toUsuario(usuarioRequest)),rolResponse,tipoDocumentoResponse);

    }
}
