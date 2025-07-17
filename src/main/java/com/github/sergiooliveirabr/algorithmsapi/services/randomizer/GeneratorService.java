package com.github.sergiooliveirabr.algorithmsapi.services.randomizer;

import com.github.sergiooliveirabr.algorithmsapi.exception.InvalidQuantityException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeneratorService {

    public int[] generateRandomNum(int qtyOfNumbersToGenerate) {

        if(qtyOfNumbersToGenerate <= 0) {
            throw new InvalidQuantityException("Number of 'Qty Of Numbers To Generate', " +
                    "which is '" + qtyOfNumbersToGenerate +"' must be greater than zero");
        }

        Random randomNumGenerator = new Random();
        int[] generatedNumbers = new int[qtyOfNumbersToGenerate];

        for (int i = 0; i < qtyOfNumbersToGenerate; i++) {
            generatedNumbers[i] = randomNumGenerator.nextInt(100);
        }
        return generatedNumbers;
    }
}
