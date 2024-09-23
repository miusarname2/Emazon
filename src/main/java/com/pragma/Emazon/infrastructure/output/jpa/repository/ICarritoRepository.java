package com.pragma.Emazon.infrastructure.output.jpa.repository;

import com.pragma.Emazon.infrastructure.output.jpa.entity.CarritoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICarritoRepository extends JpaRepository<CarritoEntity,Long> {

    @Query("SELECT c FROM CarritoEntity c WHERE c.id_articulo = :idArticulo AND c.id_usuario = :idUsuario")
    Optional<CarritoEntity> findByIdArticuloAndIdUsuario(@Param("idArticulo") Long idArticulo, @Param("idUsuario") Long idUsuario);

}
