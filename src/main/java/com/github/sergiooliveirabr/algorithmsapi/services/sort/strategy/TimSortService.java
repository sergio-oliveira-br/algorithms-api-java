package com.github.sergiooliveirabr.algorithmsapi.services.sort.strategy;

import com.github.sergiooliveirabr.algorithmsapi.services.utilities.ValidationUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TimSortService implements SortAlgorithmsStrategy {

    @Override
    public int[] sortAlgorithm(int[] arrayToSort) {

        int[] sortedArray = Arrays.copyOf(arrayToSort, arrayToSort.length);

        ValidationUtils.validateArray(arrayToSort);
        Arrays.sort(sortedArray);

        return sortedArray;
    }
}
