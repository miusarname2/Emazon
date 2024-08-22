package com.pragma.Emazon.application.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarcaRequest {
    @Size(min = 1, max = 50, message = "El nombre no puede tener más de 50 caracteres")
    private String nombre;

    @Size(min = 1,max = 90, message = "La descripción no puede superar los 90 caracteres.")
    private String descripcion;
}
