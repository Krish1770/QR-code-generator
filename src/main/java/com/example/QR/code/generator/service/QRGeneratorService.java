package com.example.QR.code.generator.service;

import com.example.QR.code.generator.dto.AcknowledgementDto;
import com.example.QR.code.generator.dto.ResponseDto;
import com.google.zxing.WriterException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface QRGeneratorService {
    byte[] generate(Long deviceId) throws WriterException, IOException;

    ResponseEntity<ResponseDto> acknowledgement(AcknowledgementDto acknowledgementDTO);

    ResponseEntity<ResponseDto> getDeviceInfo(Long deviceId);
}
