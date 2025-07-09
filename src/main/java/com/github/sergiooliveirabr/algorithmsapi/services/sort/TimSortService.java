package com.github.sergiooliveirabr.algorithmsapi.services.sort;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TimSortService implements SortAlgorithmsStrategy {

    @Override
    public int[] sortAlgorithm(int[] arrayToSort) {
        int[] sortedArray = Arrays.copyOf(arrayToSort, arrayToSort.length);
        Arrays.sort(sortedArray);

        return sortedArray;
    }
}
