package com.edu.eci.ieti.laboratorio.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TokenDTO {

    private String token;
    private Date expirationDate;

    public TokenDTO(String token, Date expirationDate){
        this.expirationDate = expirationDate;
        this.token = token;
    }

}
