package com.github.sergiooliveirabr.algorithmsapi.controller;

import com.github.sergiooliveirabr.algorithmsapi.dto.SortResult;
import com.github.sergiooliveirabr.algorithmsapi.services.randomizer.GeneratorService;
import com.github.sergiooliveirabr.algorithmsapi.services.sort.strategy.BubbleSortService;
import com.github.sergiooliveirabr.algorithmsapi.services.sort.SortOrchestratorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sort")
@CrossOrigin(origins = "http://localhost:5173")
public class SortController {

    private final GeneratorService generatorService;
    private final BubbleSortService bubbleSortService;
    private final SortOrchestratorStrategy sortOrchestratorStrategy;

    @Autowired
    public SortController(GeneratorService generatorService,
                          BubbleSortService bubbleSortService,
                          SortOrchestratorStrategy sortOrchestratorStrategy) {

        this.generatorService = generatorService;
        this.bubbleSortService = bubbleSortService;
        this.sortOrchestratorStrategy = sortOrchestratorStrategy;
    }

    @PostMapping("/generator")
    public int[] randomizer(@RequestParam int qtyOfNumbersToGenerate) {
        return generatorService.generateRandomNum(qtyOfNumbersToGenerate);
    }

    @PostMapping("/algorithms")
    public ResponseEntity<SortResult> sortAlgorithms(@RequestBody int[] generatedNumbersArray,
                                         @RequestParam String selectedAlgorithm) {

        SortResult sortResult = sortOrchestratorStrategy.sortOrchestrator(generatedNumbersArray, selectedAlgorithm);
        return ResponseEntity.ok(sortResult);
    }
}
