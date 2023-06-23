package com.example.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    
    @Id
    private Integer address_id;
    private String address1;
    private String address2;
    private String city;
    private String country;

    @OneToOne
    @JoinColumn(name = "uid")
    private UserEntity userEntity;
}
