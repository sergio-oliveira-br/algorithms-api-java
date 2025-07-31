package com.github.sergiooliveirabr.algorithmsapi.services.linearsearch;

import org.springframework.stereotype.Service;

@Service
public class FindMaxService implements FindMinOrMaxInterface{

    @Override
    public int findMinOrMax(int[] array) {

        int maxValue = array[0];

        for (int number : array){
            if (number > maxValue){
                maxValue = number;
            }
        }
        return maxValue;
    }
}
