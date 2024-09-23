package com.pragma.Emazon.application.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarritoRequest {

    @NotNull(message = "El id del artículo no puede ser nulo")
    private Long id_articulo;

    @NotNull(message = "El id del usuario no puede ser nulo")
    private Long id_usuario;

    @NotNull(message = "La cantidad no puede ser nula")
    @Digits(integer = 10, fraction = 2, message = "La cantidad debe tener como máximo 10 enteros y 2 decimales")
    @DecimalMin(value = "0.01", message = "La cantidad debe ser mayor o igual a 0.01")
    @DecimalMax(value = "9999999999.99", message = "La cantidad no puede ser mayor a 9999999999.99")
    private double cantidad;

}
