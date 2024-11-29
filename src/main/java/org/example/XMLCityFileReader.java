package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

public class XMLCityFileReader implements CityFileReader {
    public XMLCityFileReader() {
    }

    public List<Build> getBuilds(String path) throws JAXBException {
        Root root = this.readXML(path);
        return root.getBuilds();
    }

    private Root readXML(String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Root.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Root) unmarshaller.unmarshal(new File(path));
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

        @SuppressWarnings("unused")
        public void setBuilds(List<Build> builds) {
            this.builds = builds;
        }
    }
}
