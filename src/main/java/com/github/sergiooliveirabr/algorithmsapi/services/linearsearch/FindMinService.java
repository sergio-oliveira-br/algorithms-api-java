package com.github.sergiooliveirabr.algorithmsapi.services.linearsearch;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FindMinService implements FindMinOrMaxInterface {

    @Override
    public int findMinOrMax(int[] array) {

        int minValue = array[0];
        Arrays.sort(array);
        return minValue;
    }
}
