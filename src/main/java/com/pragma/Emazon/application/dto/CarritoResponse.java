package com.pragma.Emazon.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarritoResponse {

    private UsuarioResponse usuario;
    private ArticuloResponse articulo;
    private double cantidad;

}
