package com.pragma.Emazon.infrastructure.output.jpa.repository;

import com.pragma.Emazon.infrastructure.output.jpa.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<CategoriaEntity,Long> {
    boolean existsByNombre(String nombre);
}
