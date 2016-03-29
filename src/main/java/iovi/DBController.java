package iovi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aspenson on 28.03.2016.
 */
public class DBController {
    public String getCountryCurrencyCode(String country){

        String[] EUArray = new String[] {"Germany","France","Netherlands","Italy","Spain","Estonia"};
        List<String> EUList=new ArrayList<String>(Arrays.asList(EUArray));
        if (country.equals("USA"))
            return "840";
        else if (EUList.contains(country))
               return "978";
        return null;
    }

}
