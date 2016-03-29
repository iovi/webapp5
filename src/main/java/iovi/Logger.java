package iovi;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.*;
import java.nio.file.Files;

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
    public static String PrepareXML(Object xml) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(xml.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        marshaller.marshal(new JAXBElement<Object>(new QName("uri", "local"),Object.class, xml), sw);
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
}
