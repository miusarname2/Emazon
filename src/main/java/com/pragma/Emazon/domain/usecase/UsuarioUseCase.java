package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.api.IUsuarioPortService;
import com.pragma.Emazon.domain.model.Usuario;
import com.pragma.Emazon.domain.spi.IUsuarioPersistence;

public class UsuarioUseCase implements IUsuarioPortService {

    private final IUsuarioPersistence usuarioPersistence;

    public UsuarioUseCase(IUsuarioPersistence usuarioPersistence) {
        this.usuarioPersistence = usuarioPersistence;
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioPersistence.saveUsuario(usuario);
    }
}
