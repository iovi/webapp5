package iovi;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Aspenson on 16.04.2016.
 */
public class Courses {

    @XmlElement(name = "currency")
    protected String currency;
    @XmlElement(name = "rate")
    protected String rate;
    public Courses(){
        rate=null;
        currency=null;
    }
}
