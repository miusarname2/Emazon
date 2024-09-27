package com.pragma.Emazon.infrastructure.output.jpa.repository;

import com.pragma.Emazon.infrastructure.output.jpa.entity.CarritoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICarritoRepository extends JpaRepository<CarritoEntity,Long> {

    @Query("SELECT c FROM CarritoEntity c WHERE c.id_articulo = :idArticulo AND c.id_usuario = :idUsuario")
    Optional<CarritoEntity> findByIdArticuloAndIdUsuario(@Param("idArticulo") Long idArticulo, @Param("idUsuario") Long idUsuario);

    @Query("SELECT c FROM CarritoEntity c WHERE c.id_usuario = :idUsuario")
    Page<CarritoEntity> findByIdUsuario( @Param("idUsuario") Long idUsuario, Pageable pageable);
}
