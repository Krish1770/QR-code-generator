package com.example.QR.code.generator.api;


import com.example.QR.code.generator.dto.AcknowledgementDto;
import com.example.QR.code.generator.dto.ResponseDto;
import com.google.zxing.WriterException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("QR")
public interface QRGenerator {

    @PostMapping("/generation/{deviceId}")
    ResponseEntity<byte[]> generate(@PathVariable Long deviceId) throws IOException, WriterException;

    @PostMapping("/ACK")
    ResponseEntity<ResponseDto> acknowledgement(@RequestBody AcknowledgementDto acknowledgementDTO);


    @GetMapping("/Device")
    ResponseEntity<ResponseDto> getDeviceInfo(@PathVariable Long deviceId);


}
