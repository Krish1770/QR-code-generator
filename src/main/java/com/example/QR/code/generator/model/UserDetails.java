package com.example.QR.code.generator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String username;

    private String mobileNumber;
}
