package iovi;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebappResponse")
public class WebappResponse {

    @XmlElement(name = "Courses")
    protected Courses courses;
    @XmlElement(name = "Weather")
    protected Weather weather;
    public WebappResponse(){
        courses=new Courses();
        weather=new Weather();
    }
    public List<Object> getContent() {
        List<Object> all=new ArrayList<Object>();
        all.add(courses.status);
        all.add(courses.errorText);
        all.add(courses.rate);
        return all;
    }

    public void setStatus(int status) {
        courses.status=status;
    }

    public void setErrorText(String text) {
        courses.errorText=text;
    }

    public void setRate(String rate) {
        courses.rate = rate;
    }

    public void setCurrency(String currency) {
        courses.currency = currency;
    }
}