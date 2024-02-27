package com.example.QR.code.generator.Service.Impl;

import com.example.QR.code.generator.Dto.AcknowledgementDto;
import com.example.QR.code.generator.Dto.ResponseDto;
import com.example.QR.code.generator.Model.UserDetails;
import com.example.QR.code.generator.Model.UserDevice;
import com.example.QR.code.generator.Repository.Service.UserDetailsRepoService;
import com.example.QR.code.generator.Repository.Service.UserDeviceRepoService;
import com.example.QR.code.generator.Repository.UserDetailsRepo;
import com.example.QR.code.generator.Repository.UserDeviceRepo;
import com.example.QR.code.generator.Service.QRGeneratorService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class QRGeneratorServiceImpl implements QRGeneratorService {

    @Autowired
    UserDetailsRepo userDetailsRepo;
    @Autowired
    UserDetailsRepoService userDetailsRepoService;
    @Autowired
    UserDeviceRepoService userDeviceRepoService;
    @Autowired
    private UserDeviceRepo userDeviceRepo;

    @Override
    public byte[] generate(Long deviceId) throws WriterException, IOException {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(deviceId + "", BarcodeFormat.QR_CODE, 250, 250);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", out);

        return out.toByteArray();
    }

    @Override
    public ResponseEntity<ResponseDto> acknowledgement(AcknowledgementDto acknowledgementDTO) {
        UserDevice userDevice = new UserDevice();
        Optional<UserDetails> userDetails = userDetailsRepoService.findByMobileNumber(acknowledgementDTO.getMobileNumber());
        if (userDetails.isPresent()) {
            userDevice.setDeviceId(acknowledgementDTO.getDeviceId());
            userDevice.setUserDetails(userDetails.get());
            userDevice.setStatus("temporary");

            userDeviceRepo.save(userDevice);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(" connection created", HttpStatus.OK, userDevice));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("no connection created", HttpStatus.NOT_FOUND, ""));

    }

    @Override
    public ResponseEntity<ResponseDto> getDeviceInfo(Long deviceId) {


        String mobileNumber = userDeviceRepo.findById(deviceId).get().getUserDetails().getMobileNumber();

        if (mobileNumber.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("device not mapped", HttpStatus.NO_CONTENT, ""));

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("connected with the phoneNumber :" + mobileNumber, HttpStatus.OK, mobileNumber));

    }
}
