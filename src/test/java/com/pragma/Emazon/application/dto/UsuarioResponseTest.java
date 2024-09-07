package com.pragma.Emazon.application.dto;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioResponseTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        String nombre = "Ana";
        String apellido = "González";
        String correo = "ana.gonzalez@example.com";
        String celular = "9876543210";
        Date fechaNacimiento = new Date();
        String clave = "ClaveSegura123!";
        String documento = "987654321";
        RolResponse rolResponse = new RolResponse();
        TipoDocumentoResponse tipoDocumentoResponse = new TipoDocumentoResponse();

        // Act
        usuarioResponse.setNombre(nombre);
        usuarioResponse.setApellido(apellido);
        usuarioResponse.setCorreo(correo);
        usuarioResponse.setCelular(celular);
        usuarioResponse.setFecha_nacimiento(fechaNacimiento);
        usuarioResponse.setClave(clave);
        usuarioResponse.setDocumento(documento);
        usuarioResponse.setRol(rolResponse);
        usuarioResponse.setTipoDocumentoResponse(tipoDocumentoResponse);

        // Assert
        assertEquals(nombre, usuarioResponse.getNombre());
        assertEquals(apellido, usuarioResponse.getApellido());
        assertEquals(correo, usuarioResponse.getCorreo());
        assertEquals(celular, usuarioResponse.getCelular());
        assertEquals(fechaNacimiento, usuarioResponse.getFecha_nacimiento());
        assertEquals(clave, usuarioResponse.getClave());
        assertEquals(documento, usuarioResponse.getDocumento());
        assertEquals(rolResponse, usuarioResponse.getRol());
        assertEquals(tipoDocumentoResponse, usuarioResponse.getTipoDocumentoResponse());
    }
}
