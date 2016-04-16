package iovi;

import ru.cbr.web.*;
import ru.cbr.web.GetCursOnDateResponse.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Created by Aspenson on 27.03.2016.
 */
@WebService
public class GetRate {
    final static String THIS_SERVICE="webapp5";
    final static String RATES_SERVICE="http://www.cbr.ru/DailyInfoWebServ/DailyInfo.asmx";


    @WebMethod
    public WebappResponse GetRateByCountry(String country) {
        WebappResponse response=new WebappResponse();
        Logger logger = new Logger("LOG.txt");
        DailyInfoSoap soap = new DailyInfo().getDailyInfoSoap();
        XMLGregorianCalendar date = getTodayDate();
        try {
            DBController db=new DBController();
            int id=db.StartAttempt();

            try {

                String code = db.getChCodeByCountry(country);
                db.EndWorkingWithDB();
                logger.PutQueryIntoLog(id, "user", THIS_SERVICE, country);
                GetCursOnDateResult result = soap.getCursOnDate(date);
                logger.PutQueryIntoLog(id, THIS_SERVICE, RATES_SERVICE, date.toString());
                logger.PutQueryIntoLog(id, RATES_SERVICE, THIS_SERVICE, result);
                GetCursOnDateResultParser.Rate rate = GetCursOnDateResultParser.getRateByChCode(code, result);

                response.setCurrency(rate.chCode);
                response.setRate(rate.curs.toString());
                response.setStatus(1);
                logger.PutQueryIntoLog(id, THIS_SERVICE, "user", response);
                db = new DBController();
                db.EndAttempt(id, 1);
                db.EndWorkingWithDB();
                return response;
            } catch (JAXBException e){
                response.setErrorText("JAXB error " + e.getMessage());
                db=new DBController();
                db.EndAttempt(id,0);
                db.EndWorkingWithDB();
                return response;
            }
            } catch (SQLException e){
            response.setErrorText("SQL error "+e.getMessage());
            return response;
        }
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
