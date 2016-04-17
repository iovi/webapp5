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
    public String getChCodeByCountry(String country) throws SQLException {
         String query="select currencychcode from countries where countryname='"+country+"';";
         ResultSet result=connection.createStatement().executeQuery(query);
         result.next();
         String code=result.getString(1);
         result.close();
        return code;
    }
    public String getCapital(String country) throws SQLException {
        String query="select capital from countries where countryname='"+country+"';";
        ResultSet result=connection.createStatement().executeQuery(query);
        result.next();
        String code=result.getString(1);
        result.close();
        return code;
    }
    public int StartAttempt() throws SQLException{
        String query="insert into attempts (status) values(null);";
        PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        statement.executeUpdate(query);
        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        int id=(generatedKeys.getInt(1));
        return id;
    }
    public void EndAttempt(int id, int status) throws SQLException{
        String query = "update attempts set status=" + String.valueOf(status) + " where id =" + String.valueOf(id);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
    public void PutIntoLog(int id, String time, String from, String to, String text ) throws SQLException{
        String query="insert into querylog values ("+
                String.valueOf(id) +", " +
                "STR_TO_DATE('"+ time +"', '%d.%m.%Y %T'), '" +
                from +"', '" +
                to +"', '" +
                text +"');";
        connection.createStatement().executeUpdate(query);
    }
}
