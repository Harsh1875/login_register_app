package com.example.login.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class PermutationService {

    public Set<String> getStringAllPermutations(String s) {

        Set<String> result = new HashSet<>();

        if (s.length() == 0) {
            result.add("");
            return result;
        }

        char firstch = s.charAt(0);
        String rem = s.substring(1);

        Set<String> ans = getStringAllPermutations(rem);

        for (String it : ans) {
            for (int i=0; i <= it.length(); i++) {
                result.add(chInsert(it, firstch, i));
            }
        }

        return result;
    }

    private String chInsert(String it, char firstch, int i) {
        String start = it.substring(0, i);
        String end = it.substring(i);
        return start + firstch + end;
    }
    
}
