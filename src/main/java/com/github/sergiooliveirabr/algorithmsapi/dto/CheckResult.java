package com.github.sergiooliveirabr.algorithmsapi.dto;

import java.util.List;

public class CheckResult {
    private boolean hasDuplicate;
    private int duplicateCount;
    private List<Integer> duplicateNumbers;

    public CheckResult(boolean hasDuplicate, int duplicateCount, List<Integer> duplicateNumbers) {
        this.hasDuplicate = hasDuplicate;
        this.duplicateCount = duplicateCount;
        this.duplicateNumbers = duplicateNumbers;
    }

    public CheckResult() {
    }

    public boolean isHasDuplicate() {
        return hasDuplicate;
    }

    public void setHasDuplicate(boolean hasDuplicate) {
        this.hasDuplicate = hasDuplicate;
    }

    public int getDuplicateCount() {
        return duplicateCount;
    }

    public void setDuplicateCount(int duplicateCount) {
        this.duplicateCount = duplicateCount;
    }

    public List<Integer> getDuplicateNumbers() {
        return duplicateNumbers;
    }

    public void setDuplicateNumbers(List<Integer> duplicateNumbers) {
        this.duplicateNumbers = duplicateNumbers;
    }
}
