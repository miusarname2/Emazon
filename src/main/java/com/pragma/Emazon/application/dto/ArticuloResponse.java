package com.pragma.Emazon.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticuloResponse {

    private Long id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio;
    private CategoriaResponse categoria;
    private MarcaResponse marca;

}
