package com.pragma.Emazon.infrastructure.input.rest;

import com.pragma.Emazon.application.dto.UsuarioRequest;
import com.pragma.Emazon.application.dto.UsuarioResponse;
import com.pragma.Emazon.application.handler.IUsuarioHandler;
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
@RequestMapping("api/Usuario")
public class UsuarioRestController {

    private final IUsuarioHandler usuarioHandler;

    @PostMapping("crearAuxiliarBodega")
    public ResponseEntity<UsuarioResponse> saveAuxiliarBodega(@Valid @RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioHandler.saveUsuario(usuarioRequest));
    }

}
