package com.example.QR.code.generator.repository;

import com.example.QR.code.generator.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails,Long> {
   Optional <UserDetails> findByMobileNumber(String mobileNumber);
}
