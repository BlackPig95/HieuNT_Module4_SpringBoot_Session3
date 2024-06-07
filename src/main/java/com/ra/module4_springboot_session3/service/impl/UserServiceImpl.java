package com.ra.module4_springboot_session3.service.impl;

import com.ra.module4_springboot_session3.customexception.UserNameException;
import com.ra.module4_springboot_session3.model.dto.request.UserRequest;
import com.ra.module4_springboot_session3.model.entity.User;
import com.ra.module4_springboot_session3.repository.IUserRepository;
import com.ra.module4_springboot_session3.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService
{
    private final IUserRepository userRepository;

    @Override
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id)
    {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @Override
    public User insert(UserRequest userRequest) throws UserNameException
    {
        User existedUser = userRepository.findByUsername(userRequest.getUsername());
        if (existedUser != null)
        {
            throw new UserNameException("Field error: User already exist", "Message: Username existed");
        }
        User user = User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .fullname(userRequest.getFullname())
                .birthday(userRequest.getBirthday())
                .email(userRequest.getEmail())
                .gender(userRequest.getGender())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User update(User user)
    {
        findById(user.getId());
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id)
    {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }
}
