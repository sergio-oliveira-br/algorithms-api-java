package com.github.sergiooliveirabr.algorithmsapi.services.utilities;

public class ValidationUtils {

    public static void validateArray (int[] array) {
        
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
    }
}
