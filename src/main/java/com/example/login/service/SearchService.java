package com.example.login.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.exchange.SearchUsers;
import com.example.login.repositoryservice.SerachRepoService;

@Service
public class SearchService {

    @Autowired
    private SerachRepoService serachRepoService;
    
    public List<SearchUsers> find(Optional<String> name, Optional<Integer> pincode, Optional<LocalDate> regStartDate,
            Optional<LocalDate> regEndDate) {

        if (name == null && pincode == null && regStartDate == null) {
            return serachRepoService.findAll();
        }    
        else if (name != null && pincode != null && regStartDate != null) {
            return serachRepoService.findAll(name, pincode, regStartDate, regEndDate);
        }
        else if (name != null && pincode != null && regStartDate == null) {
            return serachRepoService.findNameAndPinCode(name, pincode);
        }
        else if (name != null && pincode == null && regStartDate != null) {
            return serachRepoService.findNameAndDate(name, regStartDate, regEndDate);
        }
        else if (name == null && pincode != null && regStartDate == null) {
            return serachRepoService.findDateAndPinCode(pincode, regStartDate, regEndDate);
        }
        else if (name != null && pincode == null && regStartDate == null) {
            return serachRepoService.findName(name);
        }
        else if (name == null && pincode != null && regStartDate == null) {
            return serachRepoService.findPincode(pincode);
        }
        else if (name == null && pincode == null && regStartDate != null) {
            return serachRepoService.findDate(regStartDate, regEndDate);
        }

        return null;
    }
    
}
