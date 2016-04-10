package iovi;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aspenson on 28.03.2016.
 */
public class DBController {
    private static final String url = "jdbc:mysql://localhost:3306/webapp5";
    private static final String user = "javauser";
    private static final String password = "javapass";
    Connection connection;

    public String getCountryCurrencyCode(String country){

        String[] EUArray = new String[] {"Germany","France","Netherlands","Italy","Spain","Estonia"};
        List<String> EUList=new ArrayList<String>(Arrays.asList(EUArray));
        if (country.equals("USA"))
            return "840";
        else if (EUList.contains(country))
               return "978";
        return null;
    }
    public DBController(){
        LoadDriver();
    }


    private void LoadDriver() {
       try {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           connection= DriverManager.getConnection(url,user,password);
       } catch (Exception e){}

    }
    public void EndWorkingWithDB() {
        try {
            connection.close();
        } catch (SQLException se) { }
    }
    public String getChCodeByCountry(String country)throws Exception {

        String query="select currencychcode from countries where countryname='"+country+"';";
        ResultSet result=connection.createStatement().executeQuery(query);
        result.next();
        String code=result.getString(1);
        result.close();
        return code;
    }
}
