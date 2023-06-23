package com.example.login.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.exchange.LoginRequest;
import com.example.login.exchange.RegisterUserRequest;
import com.example.login.exchange.SearchUsers;
import com.example.login.service.LoginService;
import com.example.login.service.PermutationService;
import com.example.login.service.RegisterUserService;
import com.example.login.service.SearchService;

@RestController
public class Controller {
    
    @Autowired
    private RegisterUserService registerUserService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private SearchService searchService;
    @Autowired
    private PermutationService permutationService;

    @PostMapping("/register-user")
    public String registerUserAPI(@Valid @RequestBody RegisterUserRequest registerUserRequest) {

        String response = registerUserService.registerUser(registerUserRequest);
        return response;
    }

    @PostMapping("/login")
    public String loginAPI(@Valid @RequestBody LoginRequest loginRequest) {

        String response = loginService.validateUesrLogin(loginRequest);
        return response;
    }


    @GetMapping("/search") 
    public ResponseEntity<List<SearchUsers>> searchAPI(@RequestParam("name") Optional<String> name, @RequestParam("pincode") Optional<Integer> pincode,
            @RequestParam("regStartDate") Optional<LocalDate> regStartDate,
            @RequestParam("regEndDate") Optional<LocalDate> regEndDate) {

        if ((regStartDate != null && regEndDate == null) || (regStartDate == null && regEndDate != null)) {
            return ResponseEntity.notFound().build();
        }

         List<SearchUsers> users = searchService.find(name, pincode, regStartDate, regEndDate);       

         return ResponseEntity.ok().body(users);
    }


    @GetMapping("/permutation/{str}") 
    public Set<String> permutationofStrings(@PathVariable(name = "str") String s) {
        if (s == null) {
            return null;
        }

        return permutationService.getStringAllPermutations(s); 
    }
}

/* 
1. API to Register User, with address details. In DB Address should be a different table - 
(Candidate can decide the Number of fields, but the registration date and PIN Code is mandatory)
2. API for the user to log in
3. Single API to search users by name or Pin Code or registration date (between date range) and 
the result should list page wise.
4. API which takes any string as input and returns all permutations of String (Logical)
*/