package iovi;

import ru.gismeteo.ws.HHForecast;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebappResponse")
public class WebappResponse {

    @XmlElement(name = "Status")
    protected int status;
    @XmlElement(name = "ErrorText")
    protected String errorText;
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
        all.add(status);
        all.add(errorText);
        all.add(courses.rate);
        all.add(courses.currency);
        all.add(weather.city);
        all.add(weather.forecast);
        return all;
    }

    public void setStatus(int status) { this.status=status; }

    public void setErrorText(String text) { this.errorText=text; }

    public void setRate(String rate) {
        courses.rate = rate;
    }

    public void setCurrency(String currency) {
        courses.currency = currency;
    }

    public void setCity (String city) {weather.city=city; }

    public void setForecast(HHForecast forecast) {weather.forecast=forecast; }
}