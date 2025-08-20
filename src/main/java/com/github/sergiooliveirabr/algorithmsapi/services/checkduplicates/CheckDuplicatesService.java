package com.github.sergiooliveirabr.algorithmsapi.services.checkduplicates;

import com.github.sergiooliveirabr.algorithmsapi.services.utilities.ValidationUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CheckDuplicatesService {

    public boolean isDuplicate(int[] array) {

        ValidationUtils.validateArray(array);

        Set<Integer> seenNumbers = new HashSet<>();

        for(int number: array) {
            if (seenNumbers.contains(number)){
                return true;
            }
            seenNumbers.add(number);
        }
        return false;
    }
}