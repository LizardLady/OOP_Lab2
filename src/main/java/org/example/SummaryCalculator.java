package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SummaryCalculator {
    private final List<Build> builds;

    public SummaryCalculator(List<Build> builds) {
        this.builds = builds;
    }

    public CitySummary calculate() {
        CitySummary summary = new CitySummary();
        summary.setDuplicates(getDuplicates());
        summary.setBuildsCountByFloorAndCity(getBuildsCountByFloorAndCity());
        return summary;
    }


    public Map<Build, Integer> getDuplicates() {
        HashMap<Build, Integer> duplicateBuilds = new HashMap<>();
        for (Build build : builds) {
            duplicateBuilds.merge(build, 1, Integer::sum);
        }

        new HashSet<>(duplicateBuilds.entrySet())
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .forEach(entry -> duplicateBuilds.remove(entry.getKey()));
        return duplicateBuilds;
    }

    public Map<String, Map<Integer, Integer>> getBuildsCountByFloorAndCity() {
        Map<String, Map<Integer, Integer>> buildsCountByFloorAndCity = new HashMap<>();
        for (Build build : builds) {
            buildsCountByFloorAndCity.computeIfAbsent(build.getCity(), (_) -> new HashMap<>());
            buildsCountByFloorAndCity.get(build.getCity()).merge(build.getFloor(), 1, Integer::sum);
        }
        return buildsCountByFloorAndCity;
    }
}
