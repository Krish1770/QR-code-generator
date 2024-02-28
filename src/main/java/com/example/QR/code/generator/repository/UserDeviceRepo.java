package com.example.QR.code.generator.repository;


import com.example.QR.code.generator.model.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDeviceRepo extends JpaRepository<UserDevice,Long> {
}
