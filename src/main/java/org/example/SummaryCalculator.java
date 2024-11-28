package org.example;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class SummaryCalculator {
    private List<Build> builds;

    public SummaryCalculator(List<Build> builds) {
        this.builds = builds;
    }

    public CitySummary calculate() {
        CitySummary summary = new CitySummary();
        summary.setDuplicates(getDuplicates());
        summary.setBuildCount(getBuildCount());
        return summary;
    }


    public Map<Build, Integer> getDuplicates() {
        HashMap<Build, Integer> pairs = new HashMap<>();
        for (Build build : builds) {
            pairs.merge(build, 1, Integer::sum);
        }

        new HashSet<>(pairs.entrySet())
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .forEach(entry -> pairs.remove(entry.getKey()));
        return pairs;
    }

    public Map<String, Map<Integer, Integer>> getBuildCount() {
        Map<String, Map<Integer, Integer>> cityFloorMap = new HashMap<>();
        for (Build build : builds) {
            cityFloorMap.computeIfAbsent(build.getCity(), (key) -> new HashMap<>());
            cityFloorMap.get(build.getCity()).merge(build.getFloor(), 1, Integer::sum);
        }
        return cityFloorMap;
    }
}
