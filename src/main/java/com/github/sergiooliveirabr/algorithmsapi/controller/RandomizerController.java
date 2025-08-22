package com.github.sergiooliveirabr.algorithmsapi.controller;

import com.github.sergiooliveirabr.algorithmsapi.services.randomizer.GeneratorService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:5173")
public class RandomizerController {

    private final GeneratorService generatorService;

    @Autowired
    public RandomizerController(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @PostMapping("/generator")
    public ResponseEntity<?> randomizer(@RequestParam
                                            @Min(value = 2)
                                            @Max(value = 1000)
                                            @NotNull int qtyOfNumbersToGenerate) {

        int[] generatedNumbers = generatorService.generateRandomNum(qtyOfNumbersToGenerate);
        return ResponseEntity.ok(generatedNumbers);
    }
}
