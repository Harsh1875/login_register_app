package com.example.login.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.entity.AddressEntity;
import com.example.login.entity.UserEntity;
import com.example.login.exchange.RegisterUserRequest;
import com.example.login.repositoryservice.RepoService;

@Service
public class RegisterUserService {

    @Autowired
    private RepoService repoService;

    public String registerUser(RegisterUserRequest registerUserRequest) {

        Integer uid = repoService.findUID();
        Integer address_id = repoService.findAddressID();

        UserEntity userEntity = new UserEntity(uid, registerUserRequest.getName(), registerUserRequest.getPassword(),LocalDate.now(), registerUserRequest.getPincode());
        AddressEntity addressEntity = new AddressEntity(address_id, registerUserRequest.getAddress().getAddress1(), 
            registerUserRequest.getAddress().getAddress2(),
            registerUserRequest.getAddress().getCity(), registerUserRequest.getAddress().getCountry(), userEntity);

        repoService.saveUser(userEntity);
        repoService.saveAddress(addressEntity);

        return "User Registered";
    }
    
}
