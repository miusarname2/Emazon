package com.pragma.Emazon.application.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarritoToDeleteRequest {

    @NotNull(message = "El id del artículo no puede ser nulo")
    private Long id_articulo;

    @NotNull(message = "El id del usuario no puede ser nulo")
    private Long id_usuario;


}
