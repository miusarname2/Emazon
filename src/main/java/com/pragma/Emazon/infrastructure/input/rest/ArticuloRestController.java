package com.pragma.Emazon.infrastructure.input.rest;

import com.pragma.Emazon.application.dto.ArticuloRequest;
import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.application.dto.CategoriaResponse;
import com.pragma.Emazon.application.handler.IArticuloHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Operation(summary = "Get all the articulos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All articulos returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ArticuloResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<ArticuloResponse>> getAllCategorias(){
        return ResponseEntity.ok(articuloHandler.listArticulos());
    }

}
