package com.ra.module4_springboot_session3.advice;

import com.ra.module4_springboot_session3.customexception.UserNameException;
import com.ra.module4_springboot_session3.model.dto.response.AdviceErrorData;
import org.apache.coyote.BadRequestException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class UserAdvice
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AdviceErrorData<Map<String, String>> handleBadRequest(MethodArgumentNotValidException e)
    {
        Map<String, String> map = new HashMap<>();
        e.getAllErrors().forEach(err -> map.put(err.getCode() + err.hashCode(), err.getDefaultMessage()));
        return new AdviceErrorData<>(LocalDateTime.now(), "Argument error", map, HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public AdviceErrorData<String> handleNoElement(NoSuchElementException e)
    {
        return new AdviceErrorData<>(LocalDateTime.now(), "No element", e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public AdviceErrorData<String> handleMethodNotSupport(HttpRequestMethodNotSupportedException e)
    {
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
        return new AdviceErrorData<>(LocalDateTime.now(), "Method not supported", e.getLocalizedMessage(), status, status.value());
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public AdviceErrorData<String> handleInvalidData(InvalidDataAccessApiUsageException e)
    {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new AdviceErrorData<>(LocalDateTime.now(), "Invalid data", e.getLocalizedMessage(), status, status.value());
    }

    @ExceptionHandler(UserNameException.class)
    public AdviceErrorData<String> handleUserNameDuplicate(UserNameException e)
    {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new AdviceErrorData<>(LocalDateTime.now(), "Username duplicated", e.getFieldError() + "-" + e.getLocalizedMessage(), status, status.value());
    }
}
