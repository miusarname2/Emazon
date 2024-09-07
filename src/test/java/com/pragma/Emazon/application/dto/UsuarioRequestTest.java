package com.pragma.Emazon.application.dto;

import com.pragma.Emazon.domain.model.TipoDocumento;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioRequestTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        UsuarioRequest usuarioRequest = new UsuarioRequest();
        String nombre = "Juan";
        String apellido = "Pérez";
        String correo = "juan.perez@example.com";
        String celular = "1234567890";
        Date fechaNacimiento = new Date();
        String clave = "ContraseñaSegura123!";
        String documento = "123456789";
        TipoDocumento tipoDocumento = new TipoDocumento();

        // Act
        usuarioRequest.setNombre(nombre);
        usuarioRequest.setApellido(apellido);
        usuarioRequest.setCorreo(correo);
        usuarioRequest.setCelular(celular);
        usuarioRequest.setFecha_nacimiento(fechaNacimiento);
        usuarioRequest.setClave(clave);
        usuarioRequest.setDocumento(documento);
        usuarioRequest.setTipoDocumento(tipoDocumento);

        // Assert
        assertEquals(nombre, usuarioRequest.getNombre());
        assertEquals(apellido, usuarioRequest.getApellido());
        assertEquals(correo, usuarioRequest.getCorreo());
        assertEquals(celular, usuarioRequest.getCelular());
        assertEquals(fechaNacimiento, usuarioRequest.getFecha_nacimiento());
        assertEquals(clave, usuarioRequest.getClave());
        assertEquals(documento, usuarioRequest.getDocumento());
        assertEquals(tipoDocumento, usuarioRequest.getTipoDocumento());
    }

}