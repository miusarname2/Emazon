package com.pragma.Emazon.application.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ClaveValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidClave {

    String message() default "La contraseña debe tener al menos 1 mayúscula, 1 minúscula, 8 caracteres y 1 símbolo.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
