package com.github.sergiooliveirabr.algorithmsapi.exception;

public class StrategyNotFoundException extends RuntimeException {

    public StrategyNotFoundException(String strategyName) {
        super("No such sorting strategy found for: " + strategyName);
    }

    public StrategyNotFoundException(String strategyName, Throwable cause) {
        super("No such sorting strategy found for: " + strategyName, cause);
    }
}
