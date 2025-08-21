package com.github.sergiooliveirabr.algorithmsapi.services.checkduplicates;

import com.github.sergiooliveirabr.algorithmsapi.dto.CheckResult;
import com.github.sergiooliveirabr.algorithmsapi.services.utilities.ValidationUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class CheckDuplicatesService {

    public CheckResult checkDuplicates (int[] array) {

        ValidationUtils.validateArray(array);

        Set<Integer> seenNumbers = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for(int number: array) {
            if (seenNumbers.contains(number)){
               duplicates.add(number);
            }
            seenNumbers.add(number);
        }

        CheckResult result = new CheckResult();
        result.setHasDuplicate(!duplicates.isEmpty());
        result.setDuplicateNumbers(new ArrayList<>(duplicates));
        result.setDuplicateCount(duplicates.size());

        return result;
    }
}