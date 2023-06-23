package com.example.login.repositoryservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.entity.AddressEntity;
import com.example.login.entity.UserEntity;
import com.example.login.exchange.LoginRequest;
import com.example.login.repository.AddressRepository;
import com.example.login.repository.UserRepository;

@Service
public class RepoService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public void saveAddress(AddressEntity addressEntity) {
        addressRepository.save(addressEntity);
    }

    public Integer findUID() {
        List<UserEntity> entity = userRepository.findAll();

        if (entity.size() == 0) {
            return 1;
        }

        for (int i=entity.size()-1; ;) {
            return entity.get(i).getUid() + 1;
        }
    }

    public Integer findAddressID() {
        List<AddressEntity> entities = addressRepository.findAll();

        if (entities.size() == 0) {
            return 1;
        }

        for (int i=entities.size()-1;;) {
            return entities.get(i).getAddress_id() + 1;
        }
    }

    public String validateUesrLogin(LoginRequest loginRequest) {

        UserEntity userEntity = userRepository.findByNameAndPassword(loginRequest.getName(), loginRequest.getPassword());

        if (userEntity == null) {
            return "Invalid Name or Password";
        }

        return "Successfully loggedIn";
    }
    
}
