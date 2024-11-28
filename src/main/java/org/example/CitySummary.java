package org.example;

import java.util.Map;

public class CitySummary {
    private Map<Build, Integer> duplicates;
    private Map<String, Map<Integer, Integer>> buildCount;

    public CitySummary() {
    }

    public Map<Build, Integer> getDuplicates() {
        return this.duplicates;
    }

    public void setDuplicates(Map<Build, Integer> duplicates) {
        this.duplicates = duplicates;
    }

    public Map<String, Map<Integer, Integer>> getBuildCount() {
        return this.buildCount;
    }

    public void setBuildCount(Map<String, Map<Integer, Integer>> buildCount) {
        this.buildCount = buildCount;
    }
}
