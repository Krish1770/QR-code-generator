package com.example.QR.code.generator.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcknowledgementDto {

    private String mobileNumber;

    private Long deviceId;
}
