package com.edu.eci.ieti.laboratorio.controller.auth;


import com.edu.eci.ieti.laboratorio.DTO.LoginDTO;
import com.edu.eci.ieti.laboratorio.DTO.TokenDTO;
import com.edu.eci.ieti.laboratorio.entity.User;
import com.edu.eci.ieti.laboratorio.exception.InvalidCredentialsException;
import com.edu.eci.ieti.laboratorio.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

import static com.edu.eci.ieti.laboratorio.DTO.options.Constants.CLAIMS_ROLES_KEY;
import static com.edu.eci.ieti.laboratorio.DTO.options.Constants.TOKEN_DURATION_MINUTES;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Value("${app.secret}")
    private String secret;

    @Autowired
    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public TokenDTO login(@RequestBody LoginDTO loginDTO){
        User user = userService.findByEmail(loginDTO.getEmail()).get();
        if(BCrypt.checkpw(loginDTO.getPassword(), user.getPasswordHash())) {
            return generateTokenDto(user);
        }
        else {
            throw new InvalidCredentialsException();
        }
    }

    private String generateToken(User user, Date expirationDate){
        return Jwts.builder()
                .setSubject(user.getId())
                .claim(CLAIMS_ROLES_KEY, user.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    private TokenDTO generateTokenDto( User user )
    {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add( Calendar.MINUTE, TOKEN_DURATION_MINUTES );
        String token = generateToken( user, expirationDate.getTime() );
        return new TokenDTO( token, expirationDate.getTime() );
    }

}

