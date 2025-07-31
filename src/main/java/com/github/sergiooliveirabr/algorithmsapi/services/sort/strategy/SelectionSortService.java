package com.github.sergiooliveirabr.algorithmsapi.services.sort.strategy;

import com.github.sergiooliveirabr.algorithmsapi.services.utilities.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class SelectionSortService implements SortAlgorithmsStrategy {

    @Override
    public int[] sortAlgorithm(int[] arrayToSort) {

        int arraySize = arrayToSort.length;

        ValidationUtils.validateArray(arrayToSort);

        for (int i = 0; i < arraySize; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arraySize; j++) {
                if (arrayToSort[j] < arrayToSort[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arrayToSort[i];

            arrayToSort[i] = arrayToSort[minIndex];
            arrayToSort[minIndex] = temp;
        }
        return arrayToSort;
    }
}
