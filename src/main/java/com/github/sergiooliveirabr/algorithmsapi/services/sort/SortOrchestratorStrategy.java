package com.github.sergiooliveirabr.algorithmsapi.services.sort;

import com.github.sergiooliveirabr.algorithmsapi.dto.SortResult;
import com.github.sergiooliveirabr.algorithmsapi.exception.StrategyNotFoundException;
import com.github.sergiooliveirabr.algorithmsapi.services.sort.strategy.SortAlgorithmsStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SortOrchestratorStrategy {

    private final Map<String, SortAlgorithmsStrategy> sortAlgorithmsStrategyMap;
    private final PerformanceTimer performanceTimer;

    @Autowired
    public SortOrchestratorStrategy(Map<String, SortAlgorithmsStrategy> sortAlgorithmsStrategyMap,
                                    PerformanceTimer performanceTimer) {

        this.sortAlgorithmsStrategyMap = sortAlgorithmsStrategyMap;
        this.performanceTimer = performanceTimer;
    }

    public SortResult sortOrchestrator(int[] arrayToSort,
                                       String selectedStrategy) {

        SortAlgorithmsStrategy sortAlgorithmsStrategy = sortAlgorithmsStrategyMap.get(selectedStrategy);

        if (sortAlgorithmsStrategy == null) {
            throw new StrategyNotFoundException("Strategy: '" + selectedStrategy + "' does not exist.");
        }

        try {
            PerformanceTimer.TimedResult<int[]> timedResult = performanceTimer
                    .elapsedTime(() -> sortAlgorithmsStrategy.sortAlgorithm(arrayToSort));

            // Create and return the SortResult object with the required data
            return new SortResult(
                    timedResult.result(),
                    timedResult.elapsedTimeNanoSeconds(),
                    selectedStrategy );        
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to sort array using " + selectedStrategy, e);
        }
    }
}
