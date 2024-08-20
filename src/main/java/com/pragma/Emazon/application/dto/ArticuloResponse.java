package com.pragma.Emazon.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticuloResponse {

    private Long id;
    private int cantidad;
    private double precio;
    private Long idCategoria;
    private Long idMarca;

}
