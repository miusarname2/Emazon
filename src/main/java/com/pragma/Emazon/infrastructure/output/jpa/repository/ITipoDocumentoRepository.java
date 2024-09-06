package com.pragma.Emazon.infrastructure.output.jpa.repository;

import com.pragma.Emazon.infrastructure.output.jpa.entity.TipoDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity,Long> {
    boolean existsByNombre(String nombre);
}
