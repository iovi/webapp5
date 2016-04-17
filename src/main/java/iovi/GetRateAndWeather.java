package iovi;

import ru.cbr.web.*;
import ru.cbr.web.GetCursOnDateResponse.*;
import ru.gismeteo.ws.*;
import ru.gismeteo.ws.Weather;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * Created by Aspenson on 27.03.2016.
 */
@WebService
public class GetRateAndWeather {
    final static String THIS_SERVICE="webapp5";
    final static String RATES_SERVICE="http://www.cbr.ru/DailyInfoWebServ/DailyInfo.asmx";
    final static String WEATHER_SERVICE="http://ws.gismeteo.ru/Weather/Weather.asmx";
    final static String NAME="iovi";
    final static String EMAIL="iovi@iovi.ru";
    final static String DEVICE_ID="123456";
    private WebappResponse response;
    private int attemptId;

    @WebMethod
    public WebappResponse GetResponseByCountry(String country) {
        response=new WebappResponse();
        Logger logger = new Logger("LOG.txt");
        try {
            DBController db=new DBController();
            attemptId=db.StartAttempt();
            try {
                logger.PutIntoDB(attemptId, "user", THIS_SERVICE, country);
                String code = db.getChCodeByCountry(country);
                String capital=db.getCapital(country);
                db.EndWorkingWithDB();
                //write rate into Response
                PrepareCoursersResponse(code);
                //write weather into Response
                PrepareWeatherResponse(capital);
                //set status=1 and write response into DB
                response.setStatus(1);
                logger.PutIntoDB(attemptId, THIS_SERVICE, "user", response);
                db = new DBController();
                db.EndAttempt(attemptId, 1);
                db.EndWorkingWithDB();
                return response;
            } catch (JAXBException e){
                response.setErrorText("JAXB error " + e.getMessage());
                db=new DBController();
                db.EndAttempt(attemptId,0);
                db.EndWorkingWithDB();
                return response;
            }
            } catch (SQLException e){
            response.setErrorText("SQL error "+e.getMessage());
            return response;
        }
    }

    private void PrepareCoursersResponse(String code)throws JAXBException, SQLException{
        Logger logger = new Logger();
        XMLGregorianCalendar date = getTodayDate();
        DailyInfoSoap soap = new DailyInfo().getDailyInfoSoap();
        GetCursOnDateResult result = soap.getCursOnDate(date);
        logger.PutIntoDB(attemptId, THIS_SERVICE, RATES_SERVICE, date.toString());
        logger.PutIntoDB(attemptId, RATES_SERVICE, THIS_SERVICE, result);
        GetCursOnDateResultParser.Rate rate = GetCursOnDateResultParser.getRateByChCode(code, result);
        response.setCurrency(rate.chCode);
        response.setRate(rate.curs.toString());
    }
    private void PrepareWeatherResponse (String city)throws JAXBException,SQLException {
        Logger logger = new Logger();
        response.setCity(city);

        RegisterSoap rSoap= new Register().getRegisterSoap();
        RegisterResult registerRes=rSoap.registerHHUser(NAME,EMAIL,DEVICE_ID);
        String key=registerRes.getKey();

        LocationsSoap lSoap = new Locations().getLocationsSoap();
        LocationInfoFullResult locationRes= lSoap.findByNameFull(key,city,1,"EN");
        int cityId=locationRes.getData().getLocationInfoFull().get(0).getId();

        WeatherSoap wSoap=new Weather().getWeatherSoap();
        HHForecastResult forecastRes=wSoap.getHHForecast(key,cityId);
        logger.PutIntoDB(attemptId,THIS_SERVICE,WEATHER_SERVICE,key + " "+cityId);
        logger.PutIntoDB(attemptId,WEATHER_SERVICE,THIS_SERVICE,forecastRes);
        List<HHForecast> forecasts = forecastRes.getData().getHHForecast();
        //get the nearest forecast
        HHForecast forecast=forecasts.get(0);

        response.setForecast(forecast);
    }


    public static XMLGregorianCalendar getTodayDate() {

        Date date = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        XMLGregorianCalendar today=null;
        try{
            today= DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch(DatatypeConfigurationException e) {}

        return today;
    }


}
