package com.pragma.Emazon.application.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class FechaNacimientoValidator implements ConstraintValidator<ValidFechaNacimiento,Date> {

    private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate();
    }

    private boolean isDateFormatValid(LocalDate date) {
        // Implementa la lógica si necesitas validar un formato específico
        // En este caso, estamos asumiendo que la fecha es válida si puede ser convertida correctamente
        return date != null;
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // O true si quieres permitir valores nulos
        }

        // Convertir Date a LocalDate
        LocalDate fechaLocalDate = convertToLocalDateViaInstant(value);

        // Validar formato de fecha
        if (!isDateFormatValid(fechaLocalDate)) {
            return false;
        }

        // Validar edad
        return Period.between(fechaLocalDate, LocalDate.now()).getYears() >= 18;
    }
}
