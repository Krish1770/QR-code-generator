package com.example.QR.code.generator.Repository.Service.Impl;


import com.example.QR.code.generator.Model.UserDetails;
import com.example.QR.code.generator.Repository.Service.UserDetailsRepoService;
import com.example.QR.code.generator.Repository.UserDetailsRepo;
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
