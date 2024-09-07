package com.pragma.Emazon.application.mapper;

import com.pragma.Emazon.application.dto.UsuarioRequest;
import com.pragma.Emazon.domain.model.TipoDocumento;
import com.pragma.Emazon.domain.model.Usuario;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioRequestMapperTest {

    private final UsuarioRequestMapper usuarioRequestMapper = Mappers.getMapper(UsuarioRequestMapper.class);


    @Test
    void testToUsuario() {
        // Arrange
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setId(1L);

        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setNombre("Juan");
        usuarioRequest.setApellido("Pérez");
        usuarioRequest.setCorreo("juan.perez@example.com");
        usuarioRequest.setCelular("123456789");
        usuarioRequest.setFecha_nacimiento(new java.util.Date());
        usuarioRequest.setClave("clave123");
        usuarioRequest.setDocumento("1234567890");
        usuarioRequest.setTipoDocumento(tipoDocumento);

        // Act
        Usuario usuario = usuarioRequestMapper.toUsuario(usuarioRequest);

        // Assert
        assertNotNull(usuario);
        assertEquals(usuarioRequest.getNombre(), usuario.getNombre());
        assertEquals(usuarioRequest.getApellido(), usuario.getApellido());
        assertEquals(usuarioRequest.getCorreo(), usuario.getCorreo());
        assertEquals(usuarioRequest.getCelular(), usuario.getCelular());
        assertEquals(usuarioRequest.getFecha_nacimiento(), usuario.getFecha_nacimiento());
        assertEquals(usuarioRequest.getClave(), usuario.getClave());
        assertEquals(usuarioRequest.getDocumento(), usuario.getDocumento());
        assertEquals(usuarioRequest.getTipoDocumento().getId(), usuario.getIdTipoDocumento());
    }

}