package com.example.QR.code.generator.Service;

import com.example.QR.code.generator.Dto.AcknowledgementDto;
import com.example.QR.code.generator.Dto.ResponseDto;
import com.google.zxing.WriterException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface QRGeneratorService {
    byte[] generate(Long deviceId)throws  WriterException, IOException;

    ResponseEntity<ResponseDto> acknowledgement(AcknowledgementDto acknowledgementDTO);

    ResponseEntity<ResponseDto> getDeviceInfo(Long deviceId);
}
