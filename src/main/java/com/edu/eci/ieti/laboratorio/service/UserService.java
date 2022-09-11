package com.edu.eci.ieti.laboratorio.service;

import com.edu.eci.ieti.laboratorio.DTO.UserDto;
import com.edu.eci.ieti.laboratorio.entity.User;
import com.edu.eci.ieti.laboratorio.exception.UserException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(UserDto userDto) throws UserException;

    User findById(String id);

    List<User> getAll();

    void deleteById(String id) throws UserException;

    User update(UserDto userDto, String userId) throws UserException;

    List<User> findByNameOrLastname(String query);

    List<User> findByDate(String date);

    Optional<User> findByEmail(String email);


}
