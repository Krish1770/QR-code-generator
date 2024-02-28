package com.example.QR.code.generator.repository.service;


import com.example.QR.code.generator.model.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public interface UserDetailsRepoService {

    Optional<UserDetails> findByMobileNumber(String mobileNumber);
}
