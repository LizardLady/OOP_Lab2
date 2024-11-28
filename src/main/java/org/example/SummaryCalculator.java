package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SummaryCalculator {
    private List<Build> builds;

    public SummaryCalculator(List<Build> builds) {
        this.builds = builds;
    }

    public CitySummary calculate() {
        CitySummary summary = new CitySummary();
        summary.setDuplicates(this.getDuplicates());
        summary.setBuildCount(this.getBuildCount());
        return summary;
    }

    public Map<Build, Integer> getDuplicates() {
        HashMap<Build, Integer> pairs = new HashMap();
        Iterator var2 = this.builds.iterator();

        while(var2.hasNext()) {
            Build build = (Build)var2.next();
            pairs.merge(build, 1, Integer::sum);
        }

        (new HashSet(pairs.entrySet())).stream().filter((entry) -> {
            return (Integer)entry.getValue() == 1;
        }).forEach((entry) -> {
            pairs.remove(entry.getKey());
        });
        return pairs;
    }

    public Map<String, Map<Integer, Integer>> getBuildCount() {
        Map<String, Map<Integer, Integer>> cityFloorMap = new HashMap();
        Iterator var2 = this.builds.iterator();

        while(var2.hasNext()) {
            Build build = (Build)var2.next();
            cityFloorMap.computeIfAbsent(build.getCity(), (key) -> {
                return new HashMap();
            });
            ((Map)cityFloorMap.get(build.getCity())).merge(build.getFloor(), 1, Integer::sum);
        }

        return cityFloorMap;
    }
}
