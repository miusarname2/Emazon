package com.pragma.Emazon.infrastructure.input.rest;

import com.pragma.Emazon.application.dto.CategoriaRequest;
import com.pragma.Emazon.application.handler.ICategoriaHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RequestMapping("api/categoria")
public class CategoriaRestController {

    private final ICategoriaHandler categoriaHandler;

    @Operation(summary = "Add a new categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Categoria already exists", content = @Content),
            @ApiResponse(responseCode = "400",description = "Se envio algun dato de forma erronea en la peticion.",content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> saveCategoria(@Validated @RequestBody CategoriaRequest categoriaRequest){
        categoriaHandler.saveCategoria(categoriaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
