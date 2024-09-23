package com.pragma.Emazon.application.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CarritoRequestTest {

    private CarritoRequest carritoRequest;
    private Validator validator;

    @BeforeEach
    void setUp() {
        carritoRequest = new CarritoRequest();
        // Configuramos el validador
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.afterPropertiesSet();
        validator = factoryBean.getValidator();
    }

    @Test
    void whenIdArticuloIsNull_thenValidationFails() {
        // Arrange
        carritoRequest.setId_articulo(null);
        carritoRequest.setId_usuario(1L);
        carritoRequest.setCantidad(10.00);

        // Act
        Set<ConstraintViolation<CarritoRequest>> violations = validator.validate(carritoRequest);

        // Assert
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("El id del artículo no puede ser nulo")));
    }

    @Test
    void whenIdUsuarioIsNull_thenValidationFails() {
        // Arrange
        carritoRequest.setId_articulo(1L);
        carritoRequest.setId_usuario(null);
        carritoRequest.setCantidad(10.00);

        // Act
        Set<ConstraintViolation<CarritoRequest>> violations = validator.validate(carritoRequest);

        // Assert
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("El id del usuario no puede ser nulo")));
    }

    @Test
    void whenCantidadIsLessThanMin_thenValidationFails() {
        // Arrange
        carritoRequest.setId_articulo(1L);
        carritoRequest.setId_usuario(1L);
        carritoRequest.setCantidad(0.001);  // Menor a 0.01

        // Act
        Set<ConstraintViolation<CarritoRequest>> violations = validator.validate(carritoRequest);

        // Assert
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("La cantidad debe ser mayor o igual a 0.01")));
    }

    @Test
    void whenCantidadIsGreaterThanMax_thenValidationFails() {
        // Arrange
        carritoRequest.setId_articulo(1L);
        carritoRequest.setId_usuario(1L);
        carritoRequest.setCantidad(10000000000.00);  // Mayor al máximo permitido

        // Act
        Set<ConstraintViolation<CarritoRequest>> violations = validator.validate(carritoRequest);

        // Assert
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("La cantidad no puede ser mayor a 9999999999.99")));
    }

    @Test
    void whenAllFieldsAreValid_thenValidationSucceeds() {
        // Arrange
        carritoRequest.setId_articulo(1L);
        carritoRequest.setId_usuario(1L);
        carritoRequest.setCantidad(100.00);  // Valor válido

        // Act
        Set<ConstraintViolation<CarritoRequest>> violations = validator.validate(carritoRequest);

        // Assert
        assertTrue(violations.isEmpty());
    }

}