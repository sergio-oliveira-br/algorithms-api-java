package com.github.sergiooliveirabr.algorithmsapi.services.sort.strategy;

import com.github.sergiooliveirabr.algorithmsapi.services.utilities.ValidationUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InsertionSortService implements SortAlgorithmsStrategy {

    @Override
    public int[] sortAlgorithm(int[] arrayToSort) {

        int arraySize = arrayToSort.length;

        ValidationUtils.validateArray(arrayToSort);

        for(int i = 1; i < arraySize; i++) {
            int currentValue = arrayToSort[i];
            int possition = i - 1;

            while(possition >= 0 && arrayToSort[possition] > currentValue) {
                arrayToSort[possition + 1] = arrayToSort[possition];
                possition--;
            }
            arrayToSort[possition + 1] = currentValue;
        }
        return arrayToSort;
    }
}
