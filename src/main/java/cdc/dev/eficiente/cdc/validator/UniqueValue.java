package cdc.dev.eficiente.cdc.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = UniqueValueValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {

    String message() default "Valor duplicado não permitido.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String fieldName();
    Class<?> domainClass();
}
