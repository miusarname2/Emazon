package com.pragma.Emazon.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String username;
    private String apellido;
    private String correo;
    private String celular;
    private Date fecha_nacimiento;
    private String clave;
    @Column(unique = true,nullable = false)
    private String documento;
    private Long idTipoDocumento;
    private Long id_rol;

}
