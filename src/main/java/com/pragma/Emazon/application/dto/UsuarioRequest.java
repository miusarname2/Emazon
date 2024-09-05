package com.pragma.Emazon.application.dto;

import com.pragma.Emazon.application.validation.ValidClave;
import com.pragma.Emazon.application.validation.ValidFechaNacimiento;
import com.pragma.Emazon.application.validation.ValidPhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioRequest {

    @Size(min = 1, max = 50, message = "El nombre no puede tener más de 50 caracteres, ni menos de 1 caracter.")
    private String nombre;

    @Size(min = 1, max = 50, message = "El apellido no puede tener más de 50 caracteres, ni menos de 1 caracter.")
    private String apellido;

    @Email(message = "El correo debe tener un formato válido")
    @NotBlank(message = "El correo no puede estar vacío")
    private String correo;

    @ValidPhoneNumber
    private String celular;

    @ValidFechaNacimiento
    private Date fecha_nacimiento;

    @ValidClave
    private String clave;

    @Pattern(regexp = "\\d*",message = "El documento debe ser un número.")
    @NotBlank(message = "El documento no puede esta en blanco")
    @Size(max = 15,message = "El documento no puede tener más de 15 caracteres, ni menos de 1 caracter.")
    private String documento;
}