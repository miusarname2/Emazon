package com.pragma.Emazon.application.dto;

import com.pragma.Emazon.domain.model.Categoria;
import com.pragma.Emazon.domain.model.Marca;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticuloRequest {

    @Size(min = 1, max = 50, message = "El nombre no puede tener más de 50 caracteres")
    private String nombre;

    @Size(min = 1,max = 90, message = "La descripción no puede superar los 90 caracteres.")
    private String descripcion;

    private int cantidad;

    private double precio;

    private Categoria categoria;

    private Marca marca;

}
