package com.example.QR.code.generator.Controller;


import com.example.QR.code.generator.Api.QRGenerator;
import com.example.QR.code.generator.Dto.AcknowledgementDto;
import com.example.QR.code.generator.Dto.ResponseDto;
import com.example.QR.code.generator.Service.QRGeneratorService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class QRGeneratorController implements QRGenerator {
    @Lazy
    @Autowired
    private QRGeneratorService qrGeneratorService;

    @Override
    public ResponseEntity<byte[]> generate(Long deviceId) throws IOException, WriterException {
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrGeneratorService.generate(deviceId));
    }

    @Override
    public ResponseEntity<ResponseDto> acknowledgement(AcknowledgementDto acknowledgementDTO) {
        return qrGeneratorService.acknowledgement(acknowledgementDTO);
    }

    @Override
    public ResponseEntity<ResponseDto> getDeviceInfo(Long deviceId) {
        return qrGeneratorService.getDeviceInfo(deviceId);
    }
}
