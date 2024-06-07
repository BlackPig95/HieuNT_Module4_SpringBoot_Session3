package com.ra.module4_springboot_session3.customexception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserNameException extends Exception
{
    private String fieldError;

    public UserNameException(String fieldError, String message)
    {
        super(message);
        this.fieldError = fieldError;
    }
}
