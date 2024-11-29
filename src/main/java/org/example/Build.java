package org.example;

import com.opencsv.bean.CsvBindByName;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

@SuppressWarnings("unused")
public class Build {
    @CsvBindByName
    @XmlAttribute
    private String city;
    @CsvBindByName
    @XmlAttribute
    private String street;
    @CsvBindByName
    @XmlAttribute
    private Integer house;
    @CsvBindByName
    @XmlAttribute
    private Integer floor;

    public Build() {
    }

    public String getCity() {
        return this.city;
    }

    public Integer getFloor() {
        return this.floor;
    }

    public Integer getHouse() {
        return this.house;
    }

    public String getStreet() {
        return this.street;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Build build = (Build) o;
            return Objects.equals(this.city, build.city) && Objects.equals(this.street, build.street) && Objects.equals(this.house, build.house) && Objects.equals(this.floor, build.floor);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.city, this.street, this.house, this.floor);
    }
}