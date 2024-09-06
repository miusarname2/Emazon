package com.pragma.Emazon.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioResponse {

    private String nombre;
    private String apellido;
    private String correo;
    private String celular;
    private Date fecha_nacimiento;
    private String clave;
    private String documento;
    private RolResponse rol;
    private TipoDocumentoResponse tipoDocumentoResponse;

}
