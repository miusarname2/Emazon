package com.pragma.Emazon.infrastructure.input.rest;

import com.pragma.Emazon.application.dto.*;
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

import java.util.List;

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

    @Operation(summary = "Get all Carrito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The trolleys were obtained",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CarritoResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<CarritoListResponse> obtenerCarrito(@RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
                                                              @RequestParam(value = "ascending", defaultValue = "true") boolean ascending,
                                                              @RequestParam(value = "page", defaultValue = "0") int page,
                                                              @RequestParam(value = "idUsuario",defaultValue = "0") Long id,
                                                              @RequestParam(value = "size", defaultValue = "10") int size){
        return ResponseEntity.status(HttpStatus.OK).body(carritoHandler.GetAllCarrito(sortBy,ascending,page,size,id));
    }

}
