package com.pragma.Emazon.infrastructure.exceptions;

import com.pragma.Emazon.application.dto.ResponseError;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ResponseError errores = new ResponseError();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        errores.setStatusCode(400);
        errores.setErrors(errors);

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ResponseError> handleConflict(IllegalArgumentException ex) {
        Map<String, String> errors = new HashMap<>();
        ResponseError errores = new ResponseError();

        errors.put("nombre",ex.getMessage());
        errores.setErrors(errors);
        errores.setStatusCode(409);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errores);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ResponseError> handleEntityNotFound(EntityNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        ResponseError errores = new ResponseError();

        // Mensaje original de la excepción
        String originalMessage = ex.getMessage();
        String customMessage = originalMessage;  // Usado para personalizar el mensaje

        // Verifica si el mensaje contiene la cadena específica
        if (originalMessage.contains("Unable to find com.pragma.Emazon.infrastructure.output.jpa.entity.TipoDocumentoEntity")) {
            // Extrae el ID del mensaje original
            String id = originalMessage.replaceAll("[^0-9]", "");  // Solo toma los números del mensaje
            customMessage = "No se encontró Tipo de Documento con id " + id;

            // Añade el error personalizado con la clave "tipoDocumento"
            errors.put("tipoDocumento", customMessage);
        } else {
            // Usa el mensaje original si no coincide con el caso específico
            errors.put("mensaje", originalMessage);
        }

        // Setea los errores y el código de estado
        errores.setErrors(errors);
        errores.setStatusCode(404);  // Código de estado para not found

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errores);
    }


}
