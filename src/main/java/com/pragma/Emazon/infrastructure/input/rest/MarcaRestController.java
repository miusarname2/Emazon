package com.pragma.Emazon.infrastructure.input.rest;

import com.pragma.Emazon.application.dto.MarcaRequest;
import com.pragma.Emazon.application.dto.MarcaResponse;
import com.pragma.Emazon.application.handler.ICategoriaHandler;
import com.pragma.Emazon.application.handler.IMarcaHandler;
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
@RequestMapping("api/marca")
public class MarcaRestController {

    private final IMarcaHandler marcaHandler;

    @Operation(summary = "Add a new marca on the DB")
    @ApiResponses(@ApiResponse(responseCode = "201", description = "Marca created", content = @Content))
    @PostMapping
    public ResponseEntity<MarcaResponse> saveMarca(@RequestBody MarcaRequest marcaRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaHandler.saveMarca(marcaRequest));
    }

}
