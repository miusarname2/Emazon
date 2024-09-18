package com.pragma.Emazon.infrastructure.output.jpa.repository;

import com.pragma.Emazon.infrastructure.output.jpa.entity.ArticuloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IArticuloRepository extends JpaRepository<ArticuloEntity,Long> {
    Optional<ArticuloEntity> findByNombre(String nombre);
}
