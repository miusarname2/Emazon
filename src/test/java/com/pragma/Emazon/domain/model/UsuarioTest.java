package com.pragma.Emazon.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Usuario usuario = new Usuario();
        Long expectedId = 1L;
        String expectedNombre = "Juan";
        String expectedApellido = "Pérez";
        String expectedCorreo = "juan.perez@example.com";
        String expectedCelular = "1234567890";
        Date expectedFechaNacimiento = new Date();
        String expectedClave = "password123";
        String expectedDocumento = "123456789";
        Long expectedIdTipoDocumento = 2L;
        Long expectedIdRol = 3L;

        // Act
        usuario.setId(expectedId);
        usuario.setNombre(expectedNombre);
        usuario.setApellido(expectedApellido);
        usuario.setCorreo(expectedCorreo);
        usuario.setCelular(expectedCelular);
        usuario.setFecha_nacimiento(expectedFechaNacimiento);
        usuario.setClave(expectedClave);
        usuario.setDocumento(expectedDocumento);
        usuario.setIdTipoDocumento(expectedIdTipoDocumento);
        usuario.setId_rol(expectedIdRol);

        // Assert
        assertEquals(expectedId, usuario.getId(), "El ID debería ser igual al esperado.");
        assertEquals(expectedNombre, usuario.getNombre(), "El nombre debería ser igual al esperado.");
        assertEquals(expectedApellido, usuario.getApellido(), "El apellido debería ser igual al esperado.");
        assertEquals(expectedCorreo, usuario.getCorreo(), "El correo debería ser igual al esperado.");
        assertEquals(expectedCelular, usuario.getCelular(), "El celular debería ser igual al esperado.");
        assertEquals(expectedFechaNacimiento, usuario.getFecha_nacimiento(), "La fecha de nacimiento debería ser igual a la esperada.");
        assertEquals(expectedClave, usuario.getClave(), "La clave debería ser igual a la esperada.");
        assertEquals(expectedDocumento, usuario.getDocumento(), "El documento debería ser igual al esperado.");
        assertEquals(expectedIdTipoDocumento, usuario.getIdTipoDocumento(), "El ID del tipo de documento debería ser igual al esperado.");
        assertEquals(expectedIdRol, usuario.getId_rol(), "El ID del rol debería ser igual al esperado.");
    }

}