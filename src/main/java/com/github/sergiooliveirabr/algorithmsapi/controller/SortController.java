package com.github.sergiooliveirabr.algorithmsapi.controller;

import com.github.sergiooliveirabr.algorithmsapi.dto.SortResult;
import com.github.sergiooliveirabr.algorithmsapi.services.randomizer.GeneratorService;
import com.github.sergiooliveirabr.algorithmsapi.services.sort.strategy.BubbleSortService;
import com.github.sergiooliveirabr.algorithmsapi.services.sort.SortOrchestratorStrategy;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sort")
@CrossOrigin(origins = "http://localhost:5173")
public class SortController {

    private final SortOrchestratorStrategy sortOrchestratorStrategy;

    @Autowired
    public SortController(GeneratorService generatorService,
                          SortOrchestratorStrategy sortOrchestratorStrategy) {

        this.sortOrchestratorStrategy = sortOrchestratorStrategy;
    }

    @PostMapping("/algorithms")
    public ResponseEntity<List<SortResult>> sortAlgorithms(@RequestBody int[] generatedNumbersArray,
                                                           @RequestParam @NotEmpty List<String> selectedAlgorithms) {

        if(generatedNumbersArray == null || generatedNumbersArray.length <= 1) {
            return ResponseEntity.badRequest().build();
        }

        List<SortResult> results = new ArrayList<>();

        for (String algorithm : selectedAlgorithms) {
            SortResult result = sortOrchestratorStrategy.sortOrchestrator(generatedNumbersArray, algorithm);
            results.add(result);
        }
        return ResponseEntity.ok(results);
    }
}
