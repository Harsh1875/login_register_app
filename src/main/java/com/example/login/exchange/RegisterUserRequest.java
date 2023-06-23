package com.example.login.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {

    @NonNull
    private String name;
    @NonNull
    private Integer pincode;
    @NonNull
    private String password;
    @NonNull
    private Address address;

}
