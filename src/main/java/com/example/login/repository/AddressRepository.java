package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer>{
    
}
