package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Usuario;
import com.pragma.Emazon.domain.spi.IUsuarioPersistence;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.UsuarioEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsuarioJpaAdapter implements IUsuarioPersistence {

    private final IUsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper usuarioEntityMapper;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioEntityMapper.toUsuario(usuarioRepository.save(usuarioEntityMapper.toEntity(usuario)));
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioEntityMapper.toUsuario(usuarioRepository.getById(id));
    }
}
