package com.edu.eci.ieti.laboratorio.service;

import com.edu.eci.ieti.laboratorio.DTO.UserDto;
import com.edu.eci.ieti.laboratorio.entity.User;
import com.edu.eci.ieti.laboratorio.exception.UserException;
import com.edu.eci.ieti.laboratorio.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB   implements UserService{

    private UserRepository userRepository;

    public UserServiceMongoDB(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(UserDto userDto) throws UserException {
        User user = new User(userDto);
        return userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(String id) throws UserException {
        userRepository.deleteById(id);

    }

    @Override
    public User update(UserDto userDto, String userId) throws UserException {
        User user = findById(userId);
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        userRepository.save(user);
        return user ;
    }

    @Override
    public List<User> findByNameOrLastname(String query) {
        return userRepository.findByNameLikeOrLastnameLike(query,query);
    }

    @Override
    public List<User> findByDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return userRepository.findByCreatedAtAfter(localDate);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
