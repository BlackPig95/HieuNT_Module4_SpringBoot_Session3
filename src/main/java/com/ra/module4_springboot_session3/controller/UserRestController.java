package com.ra.module4_springboot_session3.controller;

import com.ra.module4_springboot_session3.customexception.UserNameException;
import com.ra.module4_springboot_session3.model.dto.request.UserRequest;
import com.ra.module4_springboot_session3.model.dto.response.DataResponse;
import com.ra.module4_springboot_session3.model.entity.User;
import com.ra.module4_springboot_session3.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserRestController
{
    private final IUserService userService;

    @GetMapping
    public ResponseEntity<DataResponse<List<User>>> findAll()
    {
        return new ResponseEntity<>(new DataResponse<>(userService.findAll(), HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<User>> insert(@Valid @RequestBody UserRequest userRequest) throws UserNameException
    {
        return new ResponseEntity<>(new DataResponse<>(userService.insert(userRequest), HttpStatus.OK), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DataResponse<User>> update(@Valid @RequestBody User user)
    {
        return new ResponseEntity<>(new DataResponse<>(userService.update(user), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse<User>> findById(@PathVariable("id") Integer id)
    {
        return new ResponseEntity<>(new DataResponse<>(userService.findById(id), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DataResponse<?>> delete(@PathVariable("id") Integer id)
    {
        userService.delete(id);
        return new ResponseEntity<>(new DataResponse<>(null, HttpStatus.NO_CONTENT), HttpStatus.OK);
    }
}
