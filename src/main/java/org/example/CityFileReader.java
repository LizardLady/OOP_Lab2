package org.example;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

public interface CityFileReader {
    List<Build> getBuilds(String path) throws FileNotFoundException, JAXBException;
}