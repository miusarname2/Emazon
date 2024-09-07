package com.pragma.Emazon.domain.usecase;

import com.pragma.Emazon.domain.api.IRolPortService;
import com.pragma.Emazon.domain.model.Rol;
import com.pragma.Emazon.domain.spi.IRolPersistence;
import lombok.RequiredArgsConstructor;

public class RolUseCase implements IRolPortService {

    private final IRolPersistence rolPersistence;

    public RolUseCase(IRolPersistence rolPersistence) {
        this.rolPersistence = rolPersistence;
    }

    @Override
    public Rol obtenerRol(Long id) {
        return rolPersistence.obtenerRol(id);
    }
}
