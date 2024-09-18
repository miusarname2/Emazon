package com.pragma.Emazon.application.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AddArticuloRequestTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    void testGettersAndSetters() {
        // Arrange
        AddArticuloRequest addArticuloRequest = new AddArticuloRequest();
        String nombre = "Producto";
        Integer cantidad = 100;

        // Act
        addArticuloRequest.setNombre(nombre);
        addArticuloRequest.setCantidad(cantidad);

        // Assert
        assertEquals(nombre, addArticuloRequest.getNombre());
        assertEquals(cantidad, addArticuloRequest.getCantidad());
    }

    @Test
    void testNombreNotBlank() {
        // Arrange
        AddArticuloRequest addArticuloRequest = new AddArticuloRequest();
        addArticuloRequest.setNombre(""); // Nombre en blanco
        addArticuloRequest.setCantidad(100);

        // Act
        Set<ConstraintViolation<AddArticuloRequest>> violations = validator.validate(addArticuloRequest);

        // Assert
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("El nombre no puede tener más de 50 caracteres")));
    }

    @Test
    void testNombreMaxLength() {
        // Arrange
        AddArticuloRequest addArticuloRequest = new AddArticuloRequest();
        String nombreLargo = "Producto con un nombre que tiene más de cincuenta caracteres y no es válido";
        addArticuloRequest.setNombre(nombreLargo);
        addArticuloRequest.setCantidad(100);

        // Act
        Set<ConstraintViolation<AddArticuloRequest>> violations = validator.validate(addArticuloRequest);

        // Assert
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("El nombre no puede tener más de 50 caracteres")));
    }

    @Test
    void testCantidadNotNull() {
        // Arrange
        AddArticuloRequest addArticuloRequest = new AddArticuloRequest();
        addArticuloRequest.setNombre("Producto");
        addArticuloRequest.setCantidad(null); // Cantidad nula

        // Act
        Set<ConstraintViolation<AddArticuloRequest>> violations = validator.validate(addArticuloRequest);

        // Assert
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("La cantidad no puede ser nula")));
    }

    @Test
    void testCantidadValidDigits() {
        // Arrange
        AddArticuloRequest addArticuloRequest = new AddArticuloRequest();
        addArticuloRequest.setNombre("Producto");
        addArticuloRequest.setCantidad(1234567890); // Cantidad válida con 10 dígitos

        // Act
        Set<ConstraintViolation<AddArticuloRequest>> violations = validator.validate(addArticuloRequest);

        // Assert
        assertTrue(violations.isEmpty()); // No debería haber violaciones
    }

    @Test
    void testCantidadInvalidDigits() {
        // Arrange
        AddArticuloRequest addArticuloRequest = new AddArticuloRequest();
        addArticuloRequest.setNombre("Producto");
        addArticuloRequest.setCantidad(1234567890); // Más de 10 dígitos

        // Act
        Set<ConstraintViolation<AddArticuloRequest>> violations = validator.validate(addArticuloRequest);

        // Assert
        assertTrue(violations.isEmpty());
        assertFalse(violations.stream().anyMatch(v -> v.getMessage().equals("Debe ser un número válido de hasta 10 dígitos")));
    }

}