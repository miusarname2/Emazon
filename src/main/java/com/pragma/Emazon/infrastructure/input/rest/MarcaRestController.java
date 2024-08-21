package com.pragma.Emazon.infrastructure.input.rest;

import com.pragma.Emazon.application.dto.CategoriaResponse;
import com.pragma.Emazon.application.dto.MarcaRequest;
import com.pragma.Emazon.application.dto.MarcaResponse;
import com.pragma.Emazon.application.handler.IMarcaHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/marca")
public class MarcaRestController {

    private final IMarcaHandler marcaHandler;

    @Operation(summary = "Add a new marca on the DB")
    @ApiResponses(@ApiResponse(responseCode = "201", description = "Marca created", content = @Content))
    @PostMapping
    public ResponseEntity<MarcaResponse> saveMarca(@Validated @RequestBody MarcaRequest marcaRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaHandler.saveMarca(marcaRequest));
    }

    @Operation(summary = "Get All marcas returned")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "All marcas returned",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = CategoriaResponse.class)))))
    @GetMapping
    public ResponseEntity<List<MarcaResponse>> listMarca(){
        return ResponseEntity.ok(marcaHandler.listMarca());
    }

}
