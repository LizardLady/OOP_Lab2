package org.example;

public class CityFileReaderFactory {
    public CityFileReaderFactory() {
    }

    public static CityFileReader fileReaderFromPath(String path) {
        if (path.endsWith(".xml")) {
            return new XMLCityFileReader();
        } else if (path.endsWith(".csv")) {
            return new CSVCityFileReader();
        } else {
            throw new IllegalArgumentException("File extension is not supported");
        }
    }
}
