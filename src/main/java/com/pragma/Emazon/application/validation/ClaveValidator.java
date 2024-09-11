package com.pragma.Emazon.application.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClaveValidator implements ConstraintValidator<ValidClave,String> {

    private static final String MAYUSCULAS_REGEX = "(?=.*[A-Z])";
    private static final String MINUSCULAS_REGEX = "(?=.*[a-z])";
    private static final String SIMBOLOS_REGEX = "(?=.*[!@#\\$%\\^&\\*()_\\+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])";
    private static final String LONGITUD_REGEX = ".{8,}";

    private Pattern mayusculasPattern;
    private Pattern minusculasPattern;
    private Pattern simbolosPattern;
    private Pattern longitudPattern;

    @Override
    public void initialize(ValidClave constraintAnnotation) {
        mayusculasPattern = Pattern.compile(MAYUSCULAS_REGEX);
        minusculasPattern = Pattern.compile(MINUSCULAS_REGEX);
        simbolosPattern = Pattern.compile(SIMBOLOS_REGEX);
        longitudPattern = Pattern.compile(LONGITUD_REGEX);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // O true si quieres permitir valores nulos
        }

        Matcher mayusculasMatcher = mayusculasPattern.matcher(value);
        Matcher minusculasMatcher = minusculasPattern.matcher(value);
        Matcher simbolosMatcher = simbolosPattern.matcher(value);
        Matcher longitudMatcher = longitudPattern.matcher(value);

        return mayusculasMatcher.find()
                && minusculasMatcher.find()
                && simbolosMatcher.find()
                && longitudMatcher.matches();
    }
}
