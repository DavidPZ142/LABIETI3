package com.edu.eci.ieti.laboratorio.DTO;

import com.edu.eci.ieti.laboratorio.DTO.options.ErrorCodeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ServerErrorResponseDto {
    private String message;
    private ErrorCodeEnum errorCode;
    private int httpStatus;

    public  ServerErrorResponseDto(String  message, ErrorCodeEnum  errorCode, HttpStatus httpStatus) {
        this.message = message;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus.value();
    }
}
