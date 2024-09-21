package com.pragma.Emazon.infrastructure.input.rest;

import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.application.dto.UsuarioRequest;
import com.pragma.Emazon.application.dto.UsuarioResponse;
import com.pragma.Emazon.application.handler.IUsuarioHandler;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("api/Usuario")
public class UsuarioRestController {

    private final IUsuarioHandler usuarioHandler;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User Created",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UsuarioResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content),
            @ApiResponse(responseCode = "403",description = "There was a conflict or something happened",content = @Content)
    })
    @PostMapping("crearAuxiliarBodega")
    public ResponseEntity<UsuarioResponse> saveAuxiliarBodega(@Valid @RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioHandler.saveUsuario(usuarioRequest));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User Created",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UsuarioResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content),
            @ApiResponse(responseCode = "403",description = "There was a conflict or something happened",content = @Content)
    })
    @PostMapping("CrearUsuarioCliente")
    public ResponseEntity<UsuarioResponse> crearClientUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioHandler.crearUsuarioCliente(usuarioRequest));
    }

}
