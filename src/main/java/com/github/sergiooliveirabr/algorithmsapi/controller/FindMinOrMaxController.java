package com.github.sergiooliveirabr.algorithmsapi.controller;

import com.github.sergiooliveirabr.algorithmsapi.services.linearsearch.FindMaxService;
import com.github.sergiooliveirabr.algorithmsapi.services.linearsearch.FindMinOrMaxOrchestrator;
import com.github.sergiooliveirabr.algorithmsapi.services.linearsearch.findMinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/find")
@CrossOrigin("http://localhost:5173")
public class FindMinOrMaxController {

    private final findMinService findMinService;
    private final FindMaxService findMaxService;
    private final FindMinOrMaxOrchestrator findMinOrMaxOrchestrator;

    @Autowired
    public FindMinOrMaxController(findMinService findMinService,
                                  FindMaxService findMaxService,
                                  FindMinOrMaxOrchestrator findMinOrMaxOrchestrator) {
        this.findMinService = findMinService;
        this.findMaxService = findMaxService;
        this.findMinOrMaxOrchestrator = findMinOrMaxOrchestrator;
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

    @PostMapping("/{findMinOrMaxStrategy}")
    public ResponseEntity<Integer> findMinOrMax(@RequestBody int[] array,
                                                @PathVariable String findMinOrMaxStrategy) {

        int resultFound = findMinOrMaxOrchestrator.executeStrategy("find" + findMinOrMaxStrategy + "Service", array);
        return ResponseEntity.ok(resultFound);
    }
}