package org.example;

import java.util.Map;

public class CitySummary {
    private Map<Build, Integer> duplicates;
    private Map<String, Map<Integer, Integer>> buildsCountByFloorAndCity;

    public CitySummary() {
    }

    public Map<Build, Integer> getDuplicates() {
        return this.duplicates;
    }

    public void setDuplicates(Map<Build, Integer> duplicates) {
        this.duplicates = duplicates;
    }

    public Map<String, Map<Integer, Integer>> getBuildsCountByFloorAndCity() {
        return this.buildsCountByFloorAndCity;
    }

    public void setBuildsCountByFloorAndCity(Map<String, Map<Integer, Integer>> buildsCountByFloorAndCity) {
        this.buildsCountByFloorAndCity = buildsCountByFloorAndCity;
    }
}
