package com.edu.eci.ieti.laboratorio.exception;

import com.edu.eci.ieti.laboratorio.DTO.ServerErrorResponseDto;
import com.edu.eci.ieti.laboratorio.DTO.options.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

import javax.ws.rs.InternalServerErrorException;

public class InvalidCredentialsException extends InternalServerErrorException {

    private ServerErrorResponseDto serverErrorResponseDto;

    public InvalidCredentialsException() {
        super();
        ServerErrorResponseDto serverErrorResponseDto = new ServerErrorResponseDto("User not found",ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
    }

    public InvalidCredentialsException(ServerErrorResponseDto serverErrorResponseDto) {
        super();
        this.serverErrorResponseDto = serverErrorResponseDto;
    }
}
