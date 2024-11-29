package org.example;

import java.util.List;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Для запуска введите параметры");
            System.exit(0);
        }
        CityFileReader reader = CityFileReaderFactory.fileReaderFromPath(args[0]);

        try {
            long startTime = System.currentTimeMillis();
            List<Build> builds = reader.getBuilds(args[0]);
            System.out.println("Read time = " + (System.currentTimeMillis() - startTime) + "ms.");
            SummaryCalculator calculator = new SummaryCalculator(builds);
            startTime = System.currentTimeMillis();
            CitySummary summary = calculator.calculate();
            summary.getDuplicates().forEach((key, value) -> System.out.println("\t" + value + ": " + key.getCity() + ", " + key.getStreet() + ", " + key.getHouse() + ", " + key.getFloor()));
            summary.getBuildsCountByFloorAndCity().forEach((key, value) -> {
                System.out.println(key);
                value.forEach((floor, count) -> System.out.println("\t" + floor + "-floor: " + count + " builds"));
            });
            System.out.println("Process time = " + (System.currentTimeMillis() - startTime) + "ms.");
        } catch (Exception _) {
            System.out.println("Fail to process file");
        }
    }
}
