package com.pragma.Emazon.domain.api;

import com.pragma.Emazon.domain.model.Usuario;

public interface IUsuarioPortService {

    Usuario saveUsuario(Usuario usuario);

    Usuario obtenerUsuarioPorId(Long id);

}
