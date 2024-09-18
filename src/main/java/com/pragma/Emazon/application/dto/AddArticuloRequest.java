package com.pragma.Emazon.application.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class AddArticuloRequest {

    @NotBlank
    @Size(min = 1,max = 50,message = "El nombre no puede tener más de 50 caracteres" )
    private String nombre;

    @NotNull(message = "La cantidad no puede ser nula")
    @Digits(integer = 10, fraction = 0, message = "Debe ser un número válido de hasta 10 dígitos")
    private Integer cantidad;

}
