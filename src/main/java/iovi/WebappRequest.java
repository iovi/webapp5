package iovi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebappRequest")
public class WebappRequest {
    @XmlElement(name = "country")
    protected String country;


    public String getCountry() { return this.country; }

    public void setCountry(String countryName) {
        this.country = countryName;
    }

}