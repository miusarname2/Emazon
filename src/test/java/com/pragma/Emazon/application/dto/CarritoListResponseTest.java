package com.pragma.Emazon.application.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CarritoListResponseTest {

    private CarritoListResponse carritoListResponse;
    private Validator validator;

    @BeforeEach
    void setUp() {
        carritoListResponse = new CarritoListResponse();
        // Configuramos el validador
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.afterPropertiesSet();
        validator = factoryBean.getValidator();
    }

    @Test
    void whenUsuarioIsNull_thenValidationFails() {
        // Arrange
        carritoListResponse.setUsuario(null);
        carritoListResponse.setCarritoContenido(new ArrayList<>());
        carritoListResponse.setTotal(100.00);

        // Act
        Set<ConstraintViolation<CarritoListResponse>> violations = validator.validate(carritoListResponse);

        // Assert
        assertFalse(violations.isEmpty());
        assertFalse(violations.stream().anyMatch(v -> v.getMessage().equals("El usuario no puede ser nulo")));
    }

    @Test
    void whenCarritoContenidoIsNull_thenValidationFails() {
        // Arrange
        UsuarioResponse usuario = new UsuarioResponse();
        carritoListResponse.setUsuario(usuario);
        carritoListResponse.setCarritoContenido(null);  // Carrito vacío
        carritoListResponse.setTotal(100.00);

        // Act
        Set<ConstraintViolation<CarritoListResponse>> violations = validator.validate(carritoListResponse);

        // Assert
        assertTrue(violations.isEmpty());
        assertFalse(violations.stream().anyMatch(v -> v.getMessage().equals("El contenido del carrito no puede ser nulo")));
    }

    @Test
    void whenCarritoContenidoIsEmpty_thenValidationFails() {
        // Arrange
        UsuarioResponse usuario = new UsuarioResponse();
        carritoListResponse.setUsuario(usuario);
        carritoListResponse.setCarritoContenido(new ArrayList<>());  // Lista vacía
        carritoListResponse.setTotal(100.00);

        // Act
        Set<ConstraintViolation<CarritoListResponse>> violations = validator.validate(carritoListResponse);

        // Assert
        assertTrue(violations.isEmpty());
        assertFalse(violations.stream().anyMatch(v -> v.getMessage().equals("El contenido del carrito no puede estar vacío")));
    }

    @Test
    void whenTotalIsNegative_thenValidationFails() {
        // Arrange
        UsuarioResponse usuario = new UsuarioResponse();
        carritoListResponse.setUsuario(usuario);
        carritoListResponse.setCarritoContenido(List.of(new ArticuloResponse()));
        carritoListResponse.setTotal(-1.00);  // Total negativo

        // Act
        Set<ConstraintViolation<CarritoListResponse>> violations = validator.validate(carritoListResponse);

        // Assert
        assertTrue(violations.isEmpty());
        assertFalse(violations.stream().anyMatch(v -> v.getMessage().equals("El total no puede ser negativo")));
    }

    @Test
    void whenAllFieldsAreValid_thenValidationSucceeds() {
        // Arrange
        UsuarioResponse usuario = new UsuarioResponse();
        carritoListResponse.setUsuario(usuario);
        carritoListResponse.setCarritoContenido(List.of(new ArticuloResponse()));
        carritoListResponse.setTotal(100.00);  // Valores válidos

        // Act
        Set<ConstraintViolation<CarritoListResponse>> violations = validator.validate(carritoListResponse);

        // Assert
        assertTrue(violations.isEmpty());
    }
}
