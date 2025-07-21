package com.github.sergiooliveirabr.algorithmsapi.dto;

public record SortResult(
        int[] sortedArray,
        long durationNanos,
        String algorithmUsed) {
}
