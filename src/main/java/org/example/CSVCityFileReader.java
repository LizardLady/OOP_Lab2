package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CSVCityFileReader implements CityFileReader {
    public CSVCityFileReader() {
    }

    public List<Build> getBuilds(String path) throws FileNotFoundException {
        FileReader reader = new FileReader(path);
        CsvToBean<Build> csvToBean = (new CsvToBeanBuilder(reader)).withType(Build.class).withSeparator(';').build();
        return csvToBean.parse();
    }
}
