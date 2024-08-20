package com.pragma.Emazon.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticuloRequest {

    private int cantidad;
    private double precio;
    private Long idCategoria;
    private Long idMarca;

}
