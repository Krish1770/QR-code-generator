package com.example.QR.code.generator.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDto {

    private String message;

    private HttpStatus httpStatus;

    private Object object;
}
