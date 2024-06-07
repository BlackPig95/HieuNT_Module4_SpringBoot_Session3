package com.ra.module4_springboot_session3.customvalidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.lang.annotation.*;

@Constraint(
        validatedBy = {ConfirmPasswordValidator.class}
)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmPasswordAnnotation
{
    String message() default "Confirm password not match";

    String password();

    String passwordMatch();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List
    {
        ConfirmPasswordAnnotation[] value();
    }
}
