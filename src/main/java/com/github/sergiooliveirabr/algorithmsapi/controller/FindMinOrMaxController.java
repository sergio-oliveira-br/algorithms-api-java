package com.github.sergiooliveirabr.algorithmsapi.controller;

import com.github.sergiooliveirabr.algorithmsapi.services.linearsearch.FindMinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/find")
@CrossOrigin("http://localhost:5173")
public class FindMinOrMaxController {

    private final FindMinService findMinService;

    @Autowired
    public FindMinOrMaxController(FindMinService findMinService) {
        this.findMinService = findMinService;
    }

    @PostMapping("/min")
    public ResponseEntity<Integer> findMin(@RequestBody int[] array) {
        findMinService.findMinOrMax(array);
        return ResponseEntity.ok(array[0]);
    }
}
