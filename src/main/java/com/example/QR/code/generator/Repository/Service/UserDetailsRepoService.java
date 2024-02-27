package com.example.QR.code.generator.Repository.Service;


import com.example.QR.code.generator.Model.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public interface UserDetailsRepoService {

    Optional<UserDetails> findByMobileNumber(String mobileNumber);
}
