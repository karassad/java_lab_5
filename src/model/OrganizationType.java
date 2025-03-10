package model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.*;

@XmlEnum
//@XmlRootElement(name = "organizationType")
public enum OrganizationType {
    @XmlEnumValue("COMMERCIAL")
    COMMERCIAL,
    @XmlEnumValue("PUBLIC")
    PUBLIC,
    @XmlEnumValue("GOVERNMENT")
    GOVERNMENT,
    @XmlEnumValue("TRUST")
    TRUST,
    @XmlEnumValue("PRIVATE_LIMITED_COMPANY")
    PRIVATE_LIMITED_COMPANY;

}
