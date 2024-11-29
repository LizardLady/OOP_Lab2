package org.example;

import java.io.FileNotFoundException;
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
            long readDuration = System.currentTimeMillis() - startTime;
            SummaryCalculator calculator = new SummaryCalculator(builds);

            startTime = System.currentTimeMillis();

            CitySummary summary = calculator.calculate();
            System.out.println("Duplicates with count:");
            summary.getDuplicates().forEach((key, value) -> System.out.println("\t" + value + ": " + key.getCity() + ", " + key.getStreet() + ", " + key.getHouse() + ", " + key.getFloor()));

            System.out.println("----------------------------------");
            summary.getBuildsCountByFloorAndCity().forEach((key, value) -> {
                System.out.println(key);
                value.forEach((floor, count) -> System.out.println("\t" + floor + "-floor: " + count + " builds"));
            });
            System.out.println("----------------------------------");

            System.out.println("Read duration = " + readDuration + "ms.");
            System.out.println("Process duration = " + (System.currentTimeMillis() - startTime) + "ms.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception _) {
            System.out.println("Fail to process file");
        }
    }
}
