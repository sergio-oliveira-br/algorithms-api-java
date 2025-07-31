package com.github.sergiooliveirabr.algorithmsapi.services.utilities;

import com.github.sergiooliveirabr.algorithmsapi.exception.InvalidQuantityException;

public class ValidationUtils {

    public static void validateArray (int[] array) {

        if (array == null || array.length == 0) {
            throw new InvalidQuantityException("Array cannot be null or empty");
        }
    }
}
