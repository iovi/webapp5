package iovi;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Aspenson on 27.03.2016.
 */
public class Logger {
    private File file;
    public Logger (String filename)
    {
        file = new File(filename);
        if (!file.exists())
            try{
                file.createNewFile();
            } catch(IOException e){}

    }
    public Logger(){};
    public static String PrepareXML(Object xml) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(xml.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        marshaller.marshal(new JAXBElement(new QName("uri", "local"),xml.getClass(), xml), sw);
        return sw.toString();

    }
    public void PutIntoLog(String date, String note) throws IOException{

        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
        fw.append(date+" - ");
        fw.append(note);
        fw.close();
    }
    public void PutIntoLog(String date, Object xml) throws IOException, JAXBException{
        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
        fw.append(date+" - ");
        fw.append(PrepareXML(xml));
        fw.close();
    }
    public void PutIntoDB(int id, String from, String to, String query ) throws SQLException {
        SimpleDateFormat MySQLFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        DBController c = new DBController();
        c.PutIntoLog(id, MySQLFormat.format(new Date()), from, to, query);
        c.EndWorkingWithDB();

    }
    public void PutIntoDB(int id, String from, String to, Object query ) throws JAXBException, SQLException {
        SimpleDateFormat MySQLFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        DBController c = new DBController();
        c.PutIntoLog(id, MySQLFormat.format(new Date()), from, to, PrepareXML(query));
        c.EndWorkingWithDB();

    }

}
