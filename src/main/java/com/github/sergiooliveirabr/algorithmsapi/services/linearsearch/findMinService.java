package com.github.sergiooliveirabr.algorithmsapi.services.linearsearch;

import com.github.sergiooliveirabr.algorithmsapi.services.utilities.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class findMinService implements FindMinOrMaxInterface {

    @Override
    public int findMinOrMax(int[] array) {

        ValidationUtils.validateArray(array);

        int minValue = array[0];

        for (int number : array) {
            if (number < minValue) {
                minValue = number;
            }
        }
        return minValue;
    }
}
