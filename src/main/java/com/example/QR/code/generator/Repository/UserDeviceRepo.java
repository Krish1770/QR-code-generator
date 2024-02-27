package com.example.QR.code.generator.Repository;


import com.example.QR.code.generator.Model.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDeviceRepo extends JpaRepository<UserDevice,Long> {
}
