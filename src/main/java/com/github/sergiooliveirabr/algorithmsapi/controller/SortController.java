package com.github.sergiooliveirabr.algorithmsapi.controller;

import com.github.sergiooliveirabr.algorithmsapi.services.randomizer.GeneratorService;
import com.github.sergiooliveirabr.algorithmsapi.services.sort.BubbleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sort")
@CrossOrigin(origins = "http://localhost:5173")
public class SortController {

    private final GeneratorService generatorService;
    private final BubbleSortService bubbleSortService;

    @Autowired
    public SortController(GeneratorService generatorService,
                          BubbleSortService bubbleSortService) {

        this.generatorService = generatorService;
        this.bubbleSortService = bubbleSortService;
    }

    @PostMapping("/generator")
    public int[] randomizer(@RequestParam int qtyOfNumbersToGenerate) {
        return generatorService.generateRandomNum(qtyOfNumbersToGenerate);
    }

    @PostMapping("/algorithms")
    public int[] sortAlgorithms(@RequestParam int[] generatedNumbersArray) {
        System.out.println("controlador");
        return bubbleSortService.sortAlgorithm(generatedNumbersArray);
    }
}
