package iovi;

import ru.gismeteo.ws.HHForecast;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Aspenson on 16.04.2016.
 */
public class Weather {
    @XmlElement(name = "city")
    protected String city;
    @XmlElement(name = "forecast")
    protected HHForecast forecast;
    public Weather(){
        city=null;
        forecast=null;
    }
}
