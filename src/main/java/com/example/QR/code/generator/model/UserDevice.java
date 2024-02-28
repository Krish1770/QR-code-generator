package com.example.QR.code.generator.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "userDevice")
public class UserDevice {

  @Id
    private Long deviceId;

    private String status;

    private Boolean isActive;

    @ManyToOne(targetEntity = UserDetails.class,cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "userId")
    private UserDetails userDetails;
}
