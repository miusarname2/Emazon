package com.pragma.Emazon.infrastructure.output.jpa.repository;

import com.pragma.Emazon.infrastructure.output.jpa.entity.ArticuloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticuloRepository extends JpaRepository<ArticuloEntity,Long> {



}
