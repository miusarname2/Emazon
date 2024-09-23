package com.pragma.Emazon.infrastructure.input.rest;

import com.pragma.Emazon.application.dto.ArticuloResponse;
import com.pragma.Emazon.application.dto.CarritoRequest;
import com.pragma.Emazon.application.dto.CarritoResponse;
import com.pragma.Emazon.application.dto.CarritoToDeleteRequest;
import com.pragma.Emazon.application.handler.ICarritoHandler;
import com.pragma.Emazon.application.mapper.CarritoRequestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("api/carrito")
public class CarritoRestController {

    private final ICarritoHandler carritoHandler;
    private final CarritoRequestMapper carritoRequestMapper;

    @Operation(summary = "Create a new carrito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Carrito Created", content = @Content)
    })
    @PostMapping
    public ResponseEntity<CarritoResponse> saveCarrito(@Validated @RequestBody CarritoRequest carritoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(carritoHandler.saveCarrito(carritoRequest));
    }

    @Operation(summary = "Update a new carrito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Carrito Updated", content = @Content)
    })
    @PutMapping
    public ResponseEntity<CarritoResponse> updateCarrito(@Validated @RequestBody CarritoRequest carritoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(carritoHandler.updatCarrito(carritoRequest));
    }

    @Operation(summary = "Delete a Carrito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted carrito successfull",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CarritoResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @DeleteMapping
    public ResponseEntity<CarritoResponse> deleteCarrito(@Validated @RequestBody CarritoToDeleteRequest carritoRequest){
        return ResponseEntity.status(HttpStatus.OK).body(carritoHandler.deleteCarrito(carritoRequestMapper.toCarritoRequest(carritoRequest)));
    }

}
