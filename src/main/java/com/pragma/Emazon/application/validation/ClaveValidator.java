package com.pragma.Emazon.application.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ClaveValidator implements ConstraintValidator<ValidClave,String> {

    private static final String MAYUSCULAS = "(?=.*[A-Z])";
    private static final String MINUSCULAS = "(?=.*[a-z])";
    private static final String SIMBOLOS = "(?=.*[!@#\\$%\\^&\\*()_\\+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])";
    private static final String LONGITUD = ".{8,}";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // O true si quieres permitir valores nulos
        }

        return value.matches(MAYUSCULAS)
                && value.matches(MINUSCULAS)
                && value.matches(SIMBOLOS)
                && value.matches(LONGITUD);
    }
}
