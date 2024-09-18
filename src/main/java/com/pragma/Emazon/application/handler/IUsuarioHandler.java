package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.UsuarioRequest;
import com.pragma.Emazon.application.dto.UsuarioResponse;
import com.pragma.Emazon.domain.model.Usuario;

public interface IUsuarioHandler {

    UsuarioResponse saveUsuario(UsuarioRequest usuarioRequest);

    UsuarioResponse crearUsuarioCliente(UsuarioRequest usuarioRequest);

}
