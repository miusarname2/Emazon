package com.pragma.Emazon.infrastructure.input.rest;

import com.pragma.Emazon.application.dto.CategoriaRequest;
import com.pragma.Emazon.application.dto.CategoriaResponse;
import com.pragma.Emazon.application.handler.ICategoriaHandler;
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
@RequestMapping("api/categoria")
public class CategoriaRestController {

    private final ICategoriaHandler categoriaHandler;

    @Operation(summary = "Add a new categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Categoria already exists", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> saveCategoria(@RequestBody CategoriaRequest categoriaRequest){
        categoriaHandler.saveCategoria(categoriaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get all the categorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All categorias returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CategoriaResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> getAllCategorias(@RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
                                                                    @RequestParam(value = "ascending", defaultValue = "true") boolean ascending,
                                                                    @RequestParam(value = "page", defaultValue = "0") int page,
                                                                    @RequestParam(value = "size", defaultValue = "10") int size){
        return ResponseEntity.ok(categoriaHandler.listCategoria(sortBy,ascending,page,size));
    }
}
