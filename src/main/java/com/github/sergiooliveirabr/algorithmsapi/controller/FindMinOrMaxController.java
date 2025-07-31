package com.github.sergiooliveirabr.algorithmsapi.controller;

import com.github.sergiooliveirabr.algorithmsapi.services.linearsearch.FindMaxService;
import com.github.sergiooliveirabr.algorithmsapi.services.linearsearch.FindMinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/find")
@CrossOrigin("http://localhost:5173")
public class FindMinOrMaxController {

    private final FindMinService findMinService;
    private final FindMaxService findMaxService;

    @Autowired
    public FindMinOrMaxController(FindMinService findMinService,
                                  FindMaxService findMaxService) {
        this.findMinService = findMinService;
        this.findMaxService = findMaxService;
    }

    @PostMapping("/min-value")
    public ResponseEntity<Integer> findMin(@RequestBody int[] array) {
        int minValue = findMinService.findMinOrMax(array);
        return ResponseEntity.ok(minValue);
    }

    @PostMapping("/max-value")
    public ResponseEntity<Integer> findMax(@RequestBody int[] array) {
        int maxValue = findMaxService.findMinOrMax(array);
        return ResponseEntity.ok(maxValue);
    }
}