package com.example.QR.code.generator.repository.service.impl;


import com.example.QR.code.generator.model.UserDetails;
import com.example.QR.code.generator.repository.service.UserDetailsRepoService;
import com.example.QR.code.generator.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsRepoImpl implements UserDetailsRepoService {
    @Lazy
    @Autowired
    private UserDetailsRepo userDetailsRepo;


    @Override
    public Optional<UserDetails> findByMobileNumber(String mobileNumber) {
        return userDetailsRepo.findByMobileNumber(mobileNumber);
    }
}
