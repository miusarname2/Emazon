package com.pragma.Emazon.infrastructure.output.jpa.adapter;

import com.pragma.Emazon.domain.model.Rol;
import com.pragma.Emazon.domain.spi.IRolPersistence;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.RolEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.mapper.UsuarioEntityMapper;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IRolRepository;
import com.pragma.Emazon.infrastructure.output.jpa.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RolJpaAdapter implements IRolPersistence {

    private final IRolRepository rolRepository;
    private final RolEntityMapper rolEntityMapper;

    @Override
    public Rol obtenerRol(Long id) {
        return rolEntityMapper.toRol(rolRepository.getById(id));
    }
}
