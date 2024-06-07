package com.ra.module4_springboot_session3.service;

import com.ra.module4_springboot_session3.customexception.UserNameException;
import com.ra.module4_springboot_session3.model.dto.request.UserRequest;
import com.ra.module4_springboot_session3.model.entity.User;

import java.util.List;

public interface IUserService
{
    List<User> findAll();

    User findById(Integer id);

    User insert(UserRequest userRequest) throws UserNameException;

    User update(User user);

    void delete(Integer id);

    User findByUsername(String username);
}
