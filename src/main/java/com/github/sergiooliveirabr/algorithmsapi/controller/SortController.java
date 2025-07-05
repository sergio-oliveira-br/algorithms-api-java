package com.github.sergiooliveirabr.algorithmsapi.controller;

import com.github.sergiooliveirabr.algorithmsapi.services.randomizer.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sort")
@CrossOrigin(origins = "http://localhost:5173")
public class SortController {

    private final GeneratorService generatorService;

    @Autowired
    public SortController(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @PostMapping("/generator")
    public int[] randomizer(@RequestParam int qtyOfNumbersToGenerate) {
        return generatorService.generateRandomNum(qtyOfNumbersToGenerate);
    }
}
