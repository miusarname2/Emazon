package com.pragma.Emazon.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarritoListResponse {

    private UsuarioResponse Usuario;
    private List<ArticuloResponse> carritoContenido;
    private double total;

}
