package com.github.sergiooliveirabr.algorithmsapi.services.sort.strategy;

import com.github.sergiooliveirabr.algorithmsapi.services.utilities.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class BubbleSortService implements SortAlgorithmsStrategy {

    @Override
    public int[] sortAlgorithm(int[] arrayToSort) {

        int arraySize = arrayToSort.length;

        ValidationUtils.validateArray(arrayToSort);
        
        for (int i = 0; i < arraySize; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                if (arrayToSort[i] > arrayToSort[j]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
            }
        }
        return arrayToSort;
    }
}
