package com.pragma.Emazon.application.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ResponseErrorTest {

    private ResponseError responseError;

    @BeforeEach
    void setUp() {
        responseError = new ResponseError();
        responseError.setErrors(new HashMap<>());
    }

    @Test
    void putError() {
        // Act
        responseError.putError("nombre", "El nombre es obligatorio");

        // Assert
        assertEquals("El nombre es obligatorio", responseError.getErrors().get("nombre"));
    }

}