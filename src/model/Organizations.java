package model;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.*;

import java.util.List;
@XmlRootElement(name = "organizations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organizations {

    @XmlElement(name = "organization")
    private List<Organization> organizations;

    // Геттеры и сеттеры
    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }
}
