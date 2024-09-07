package com.pragma.Emazon.domain.spi;

import com.pragma.Emazon.domain.model.Usuario;

public interface IUsuarioPersistence {

    Usuario saveUsuario(Usuario usuario);

}
