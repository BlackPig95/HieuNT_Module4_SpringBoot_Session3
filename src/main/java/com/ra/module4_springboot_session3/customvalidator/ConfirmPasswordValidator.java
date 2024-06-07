package com.ra.module4_springboot_session3.customvalidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Objects;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPasswordAnnotation, Object>
{
    private String password;
    private String confirmPassword;

    @Override
    public void initialize(ConfirmPasswordAnnotation constraintAnnotation)
    {
        this.password = constraintAnnotation.password();
        this.confirmPassword = constraintAnnotation.passwordMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context)
    {
        Object passwordValue = new BeanWrapperImpl(value).getPropertyValue(password);
        Object confirmPasswordValue = new BeanWrapperImpl(value).getPropertyValue(confirmPassword);
        return Objects.equals(passwordValue, confirmPasswordValue);
//        return this.password.equals(this.confirmPassword);
    }


}
