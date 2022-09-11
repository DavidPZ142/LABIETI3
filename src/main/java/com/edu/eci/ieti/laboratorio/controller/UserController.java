package com.edu.eci.ieti.laboratorio.controller;


import com.edu.eci.ieti.laboratorio.DTO.UserDto;
import com.edu.eci.ieti.laboratorio.entity.User;
import com.edu.eci.ieti.laboratorio.exception.UserException;
import com.edu.eci.ieti.laboratorio.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> create( @RequestBody UserDto userDto ) {
        ModelMapper modelMapper = new ModelMapper();
        try{
            User user = modelMapper.map(userDto,User.class);
            userService.create(user);
            return new ResponseEntity<>(userDto, HttpStatus.CREATED);
        } catch (UserException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List <User> users = userService.getAll();
        return new ResponseEntity<>(users,HttpStatus.ACCEPTED);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<UserDto> findById( @PathVariable String id ) {
        ModelMapper modelMapper = new ModelMapper();
        System.out.println(userService.findById(id));
        UserDto userDto= modelMapper.map(userService.findById(id),UserDto.class);

        return new ResponseEntity<>(userDto,HttpStatus.ACCEPTED);
    }



    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id ) throws UserException {
            return new ResponseEntity<>(userService.update(userDto,id), HttpStatus.OK);
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<String > delete( @PathVariable String id ) {
        try{
            userService.deleteById(id);
            return new ResponseEntity<>("Borrado",HttpStatus.ACCEPTED);
        }catch (UserException e) {
            return new ResponseEntity<>(e.toString(),HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/name/{query}")
    public ResponseEntity<List<User>> findByNameOrLastname(@PathVariable String query){
        return new ResponseEntity<>(userService.findByNameOrLastname(query),HttpStatus.ACCEPTED);
    }
    @GetMapping("/date/{query}")
    public ResponseEntity<List<User>> findAfterDate(@PathVariable String query){
        return new ResponseEntity<>(userService.findByDate(query),HttpStatus.ACCEPTED);
    }
}

