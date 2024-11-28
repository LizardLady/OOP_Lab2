package org.example;

import java.io.FileNotFoundException;
import java.util.List;
import javax.xml.bind.JAXBException;

public interface CityFileReader {
    List<Build> getBuilds(String var1) throws FileNotFoundException, JAXBException;
}