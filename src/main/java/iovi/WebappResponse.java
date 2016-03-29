package iovi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebappResponse")
public class WebappResponse {
    @XmlElement(name = "status")
    protected int status;
    @XmlElement(name = "errortext")
    protected String errorText;
    @XmlElement(name = "currency")
    protected String currency;
    @XmlElement(name = "rate")
    protected String rate;


    public WebappResponse(){
        status=0;
        errorText=null;
        rate=null;
        currency=null;
    }
    public List<Object> getContent() {
        List<Object> all=new ArrayList<Object>();
        all.add(status);
        all.add(errorText);
        all.add(rate);
        return all;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setErrorText(String text) {
        this.errorText=text;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}