package com.github.sergiooliveirabr.algorithmsapi.controller;

import com.github.sergiooliveirabr.algorithmsapi.dto.CheckResult;
import com.github.sergiooliveirabr.algorithmsapi.services.checkduplicates.CheckDuplicatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/check")
@CrossOrigin("http://localhost:5173")
public class CheckDuplicatesController {

    private final CheckDuplicatesService checkDuplicatesService;

    @Autowired
    public CheckDuplicatesController(CheckDuplicatesService checkDuplicatesService) {
        this.checkDuplicatesService = checkDuplicatesService;
    }

    @PostMapping("/duplicates")
    public ResponseEntity<CheckResult> checkForDuplicates(@RequestBody int[] array) {

        CheckResult result = checkDuplicatesService.checkDuplicates(array);
        return ResponseEntity.ok(result);
    }
}