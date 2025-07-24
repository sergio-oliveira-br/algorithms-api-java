package com.github.sergiooliveirabr.algorithmsapi.controller;

import com.github.sergiooliveirabr.algorithmsapi.dto.SortResult;
import com.github.sergiooliveirabr.algorithmsapi.services.randomizer.GeneratorService;
import com.github.sergiooliveirabr.algorithmsapi.services.sort.strategy.BubbleSortService;
import com.github.sergiooliveirabr.algorithmsapi.services.sort.SortOrchestratorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<?> randomizer(@RequestParam int qtyOfNumbersToGenerate) {

        if(qtyOfNumbersToGenerate <= 0) {
            return ResponseEntity.badRequest().body(new int[0]);
        }
        if(qtyOfNumbersToGenerate > 1000) {
            return ResponseEntity.status(422).build();
        }

        int[] generatedNumbers = generatorService.generateRandomNum(qtyOfNumbersToGenerate);
        return ResponseEntity.ok(generatedNumbers);
    }

    @PostMapping("/algorithms")
    public ResponseEntity<List<SortResult>> sortAlgorithms(@RequestBody int[] generatedNumbersArray,
                                                           @RequestParam List<String> selectedAlgorithms) {
        
        List<SortResult> results = new ArrayList<>();

        for (String algorithm : selectedAlgorithms) {
            SortResult result = sortOrchestratorStrategy.sortOrchestrator(generatedNumbersArray, algorithm);
            results.add(result);
        }
        return ResponseEntity.ok(results);
    }
}
