package com.pragma.Emazon.application.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // Si es opcional, puedes cambiar esto según el caso
        }
        return value.matches("^\\+\\d{10,13}$");
    }
}
