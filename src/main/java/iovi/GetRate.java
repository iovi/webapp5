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
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Created by Aspenson on 27.03.2016.
 */
@WebService
public class GetRate {
    @WebMethod
    public WebappResponse GetRateByCountry(String country) {
        WebappResponse response=new WebappResponse();
        Logger logger = new Logger("LOG.TXT");
        try {
            DailyInfoSoap soap = new DailyInfo().getDailyInfoSoap();
            XMLGregorianCalendar date = getTodayDate();

            logger.PutIntoLog(date.toString(),country+"\n");
            DBController db=new DBController();
            String code=db.getChCodeByCountry(country);
            db.EndWorkingWithDB();

            GetCursOnDateResult result = soap.getCursOnDate(date);
            GetCursOnDateResultParser.Rate rate = GetCursOnDateResultParser.getRateByChCode(code, result);

            response.setCurrency(rate.chCode);
            response.setRate(rate.curs.toString());
            response.setStatus(1);
            logger.PutIntoLog(date.toString(),response);
            return response;
        }catch (Exception e){
            response.setErrorText(e.getMessage());
            try {
                XMLGregorianCalendar date = getTodayDate();
                logger.PutIntoLog(date.toString(),response);
            } catch (Exception e1){
                response.setErrorText(e1.getMessage());}
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
