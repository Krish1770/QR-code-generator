package com.example.QR.code.generator.Repository;

import com.example.QR.code.generator.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails,Long> {
   Optional <UserDetails> findByMobileNumber(String mobileNumber);
}
