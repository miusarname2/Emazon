package com.pragma.Emazon.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articulo")
public class ArticuloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private double precio;
    @JoinColumn(name = "id_categoria")
    private Long idCategoria;
    @JoinColumn(name = "id_marca")
    private Long idMarca;

}
