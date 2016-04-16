package iovi;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Aspenson on 16.04.2016.
 */
public class Courses {
    @XmlElement(name = "status")
    protected int status;
    @XmlElement(name = "errortext")
    protected String errorText;
    @XmlElement(name = "currency")
    protected String currency;
    @XmlElement(name = "rate")
    protected String rate;
    public Courses(){
        status=0;
        errorText=null;
        rate=null;
        currency=null;
    }
}
