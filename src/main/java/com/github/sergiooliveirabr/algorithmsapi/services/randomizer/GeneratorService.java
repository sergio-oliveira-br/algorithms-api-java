package com.github.sergiooliveirabr.algorithmsapi.services.randomizer;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeneratorService {

    public int[] generateRandomNum(int qtyOfNumbersToGenerate) {

        Random randomNumGenerator = new Random();
        int[] generatedNumbers = new int[qtyOfNumbersToGenerate];

        for (int i = 0; i < qtyOfNumbersToGenerate; i++) {
            generatedNumbers[i] = randomNumGenerator.nextInt(100);
        }
        return generatedNumbers;
    }
}
