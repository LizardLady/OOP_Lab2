package org.example;

public class CityFileReaderFactory {
    public CityFileReaderFactory() {
    }

    public static CityFileReader fileReaderFromPath(String path) {
        if (path.substring(path.length() - 4).equals(".xml")) {
            return new XMLCityFileReader();
        } else if (path.substring(path.length() - 4).equals(".csv")) {
            return new CSVCityFileReader();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
