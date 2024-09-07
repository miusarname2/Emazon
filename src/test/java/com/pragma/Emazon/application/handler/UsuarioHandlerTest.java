package com.pragma.Emazon.application.handler;

import com.pragma.Emazon.application.dto.RolResponse;
import com.pragma.Emazon.application.dto.TipoDocumentoResponse;
import com.pragma.Emazon.application.dto.UsuarioRequest;
import com.pragma.Emazon.application.dto.UsuarioResponse;
import com.pragma.Emazon.application.mapper.RolResponseMapper;
import com.pragma.Emazon.application.mapper.TipoDocumentoResponseMapper;
import com.pragma.Emazon.application.mapper.UsuarioRequestMapper;
import com.pragma.Emazon.application.mapper.UsuarioResponseMapper;
import com.pragma.Emazon.domain.api.IRolPortService;
import com.pragma.Emazon.domain.api.ITipoDocumentoPortService;
import com.pragma.Emazon.domain.api.IUsuarioPortService;
import com.pragma.Emazon.domain.model.Rol;
import com.pragma.Emazon.domain.model.TipoDocumento;
import com.pragma.Emazon.domain.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioHandlerTest {

    @Mock
    private IUsuarioPortService usuarioPortService;

    @Mock
    private UsuarioRequestMapper usuarioRequestMapper;

    @Mock
    private UsuarioResponseMapper usuarioResponseMapper;

    @Mock
    private IRolPortService rolPortService;

    @Mock
    private RolResponseMapper rolResponseMapper;

    @Mock
    private ITipoDocumentoPortService tipoDocumentoPortService;

    @Mock
    private TipoDocumentoResponseMapper tipoDocumentoResponseMapper;

    @InjectMocks
    private UsuarioHandler usuarioHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveUsuario(){
        TipoDocumento documento = new TipoDocumento();
        documento.setId(1L);

        // Arrange
        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setNombre("Juan");
        usuarioRequest.setApellido("Pérez");
        usuarioRequest.setClave("Testing");
        usuarioRequest.setTipoDocumento(documento);


        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Pérez");
        usuario.setId_rol(2L);

        RolResponse rolResponse = new RolResponse();
        rolResponse.setNombre("Usuario");

        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setNombre("Cédula");

        TipoDocumentoResponse tipoDocumentoResponse = new TipoDocumentoResponse();
        tipoDocumentoResponse.setNombre("Cédula");

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setNombre("Juan");
        usuarioResponse.setApellido("Pérez");
        usuarioResponse.setRol(rolResponse);
        usuarioResponse.setTipoDocumentoResponse(tipoDocumentoResponse);

        when(usuarioRequestMapper.toUsuario(usuarioRequest)).thenReturn(usuario);
        when(rolPortService.obtenerRol(2L)).thenReturn(new Rol());
        when(rolResponseMapper.toResponse(any())).thenReturn(rolResponse);
        when(tipoDocumentoPortService.obtenerTipoDocumento(anyLong())).thenReturn(tipoDocumento);  // Corregido aquí
        when(tipoDocumentoResponseMapper.toResponse(tipoDocumento)).thenReturn(tipoDocumentoResponse); // Corregido aquí
        when(usuarioPortService.saveUsuario(usuario)).thenReturn(usuario);
        when(usuarioResponseMapper.toResponse(usuario, rolResponse, tipoDocumentoResponse)).thenReturn(usuarioResponse);

        // Act
        UsuarioResponse response = usuarioHandler.saveUsuario(usuarioRequest);

        // Assert
        assertEquals(usuarioResponse, response);
        verify(usuarioRequestMapper).toUsuario(usuarioRequest);
        verify(rolPortService).obtenerRol(2L);
        verify(rolResponseMapper).toResponse(any());
        verify(tipoDocumentoPortService).obtenerTipoDocumento(anyLong());  // Corregido aquí
        verify(tipoDocumentoResponseMapper).toResponse(tipoDocumento);    // Corregido aquí
        verify(usuarioPortService).saveUsuario(usuario);
        verify(usuarioResponseMapper).toResponse(usuario, rolResponse, tipoDocumentoResponse);
    }

}