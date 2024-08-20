package com.pragma.Emazon.infrastructure.input.rest;

import com.pragma.Emazon.application.dto.ArticuloRequest;
import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.application.handler.IArticuloHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/articulo")
public class ArticuloRestController {

    private final IArticuloHandler articuloHandler;

    @Operation(summary = "Create New articulo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Marca created", content = @Content)
    })
    @PostMapping
    public ResponseEntity<ArticuloResponse> saveArticulo(@RequestBody ArticuloRequest articuloRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(articuloHandler.saveArticulo(articuloRequest));
    }

}
