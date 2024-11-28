package org.example;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class XMLCityFileReader implements CityFileReader {
    public XMLCityFileReader() {
    }

    public List<Build> getBuilds(String path) throws JAXBException {
        Root root = this.readXML(path);
        List<Build> builds = root.getBuilds();
        return builds;
    }

    public Root readXML(String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(new Class[]{Root.class});
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Root)unmarshaller.unmarshal(new File(path));
    }

    @XmlRootElement
    private static class Root {
        private List<Build> builds;

        private Root() {
        }

        @XmlElement(
                name = "item"
        )
        public List<Build> getBuilds() {
            return this.builds;
        }

        public void setBuilds(List<Build> builds) {
            this.builds = builds;
        }
    }
}
