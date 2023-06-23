package com.example.login.repositoryservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.entity.UserEntity;
import com.example.login.exchange.SearchUsers;
import com.example.login.repository.UserRepository;

@Service
public class SerachRepoService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<SearchUsers> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();

        List<SearchUsers> users = new ArrayList<>();

        for (UserEntity it : userEntities) {
            users.add(modelMapper.map(it, SearchUsers.class));
        }

        return users;
    }

    public List<SearchUsers> findAll(Optional<String> name, Optional<Integer> pincode, Optional<LocalDate> regStartDate,
            Optional<LocalDate> regEndDate) {

        List<UserEntity> userEntities = userRepository.dateRangeWithNameAndPincode(regStartDate, regEndDate, name, pincode);
        List<SearchUsers> users = new ArrayList<>();

        for (UserEntity it : userEntities) {
            users.add(modelMapper.map(it, SearchUsers.class));
        }

        return users;

    }

    public List<SearchUsers> findNameAndPinCode(Optional<String> name, Optional<Integer> pincode) {
        List<UserEntity> userEntities = userRepository.findByNameAndPincode(name, pincode);
        List<SearchUsers> users = new ArrayList<>();

        for (UserEntity it : userEntities) {
            users.add(modelMapper.map(it, SearchUsers.class));
        }

        return users;
    }

    public List<SearchUsers> findNameAndDate(Optional<String> name, Optional<LocalDate> regStartDate,
            Optional<LocalDate> regEndDate) {
        List<UserEntity> userEntities = userRepository.dateRangeWithName(regStartDate, regEndDate, name);

        List<SearchUsers> users = new ArrayList<>();

        for (UserEntity it : userEntities) {
            users.add(modelMapper.map(it, SearchUsers.class));
        }

        return users;
    }

    public List<SearchUsers> findDateAndPinCode(Optional<Integer> pincode, Optional<LocalDate> regStartDate,
            Optional<LocalDate> regEndDate) {
        List<UserEntity> userEntities = userRepository.dateRangeWithPincode(regStartDate, regEndDate, pincode);

        List<SearchUsers> users = new ArrayList<>();

        for (UserEntity it : userEntities) {
            users.add(modelMapper.map(it, SearchUsers.class));
        }

        return users;
    }

    public List<SearchUsers> findName(Optional<String> name) {
        List<UserEntity> userEntities = userRepository.findByName(name);
        List<SearchUsers> users = new ArrayList<>();

        for (UserEntity it : userEntities) {
            users.add(modelMapper.map(it, SearchUsers.class));
        }

        return users;
    }

    public List<SearchUsers> findPincode(Optional<Integer> pincode) {
        List<UserEntity> userEntities = userRepository.findByPincode(pincode);
        List<SearchUsers> users = new ArrayList<>();

        for (UserEntity it : userEntities) {
            users.add(modelMapper.map(it, SearchUsers.class));
        }

        return users;
    }

    public List<SearchUsers> findDate(Optional<LocalDate> regStartDate, Optional<LocalDate> regEndDate) {
        List<UserEntity> userEntities = userRepository.dateRange(regStartDate, regEndDate);

        List<SearchUsers> users = new ArrayList<>();

        for (UserEntity it : userEntities) {
            users.add(modelMapper.map(it, SearchUsers.class));
        }

        return users;
    }
    
}
