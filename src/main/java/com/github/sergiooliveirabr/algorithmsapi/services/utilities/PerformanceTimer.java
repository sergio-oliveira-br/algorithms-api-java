package com.github.sergiooliveirabr.algorithmsapi.services.utilities;

import com.github.sergiooliveirabr.algorithmsapi.dto.SortResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

@Service
public class PerformanceTimer {

    public <T>TimedResult<T> elapsedTime(Callable<T> operation) throws Exception {

        long startTime = System.nanoTime();
        T result = operation.call();
        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;

        return new TimedResult<>(result, elapsedTime);
    }

    // Record (internal DTO) to encapsulate the result of an operation and its execution times.
   public record TimedResult<T>(T result, long elapsedTimeNanoSeconds){}
}
