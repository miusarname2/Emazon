package com.pragma.Emazon.infrastructure.output.jpa.repository;

import com.pragma.Emazon.infrastructure.output.jpa.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMarcaRepository extends JpaRepository<MarcaEntity,Long> {
    boolean existsByNombre(String nombre);
}
