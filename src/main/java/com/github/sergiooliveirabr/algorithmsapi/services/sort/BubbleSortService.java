package com.github.sergiooliveirabr.algorithmsapi.services.sort;

import org.springframework.stereotype.Service;

@Service
public class BubbleSortService implements SortAlgorithmsStrategy{

    @Override
    public int[] sortAlgorithm(int[] arrayToSort) {

        int arraySize = arrayToSort.length;

        if (arraySize == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
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
