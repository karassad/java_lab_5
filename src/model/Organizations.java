package model;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
@XmlRootElement(name = "organizations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organizations {

    @XmlElement(name = "organization")
    private LinkedHashSet<Organization> organizations;

    // Геттеры и сеттеры
    public LinkedHashSet<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(LinkedHashSet<Organization> organizations) {
        this.organizations = organizations;
    }
}
