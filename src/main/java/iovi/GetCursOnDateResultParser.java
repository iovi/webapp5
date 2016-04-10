/**
 * Created by Aspenson on 26.03.2016.
 */
package iovi;

import java.math.BigDecimal;
import java.util.List;


import org.apache.xerces.dom.ElementNSImpl;
import org.apache.xerces.dom.TextImpl;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ru.cbr.web.GetCursOnDateResponse.*;
import ru.cbr.web.GetCursOnDateXMLResponse.GetCursOnDateXMLResult;

public class GetCursOnDateResultParser {

    public static class Rate {
        public String name;
        public String chCode;
        public int code;
        public BigDecimal nom;
        public BigDecimal curs;

        public Rate(){

        }

        public Rate(String vname, String vchcode, int vcode, BigDecimal vnom, BigDecimal vcurs){
            this.name = vname;
            this.chCode = vchcode;
            this.code = vcode;
            this.nom = vnom;
            this.curs = vcurs;
        }
    }

    public static Rate getRateByChCode(String valuteCode, GetCursOnDateResult result) throws Exception{

        Rate answer = new Rate();

        ElementNSImpl e = (ElementNSImpl) result.getAny();
        NodeList chCodeList =   e.getElementsByTagName("VchCode");
        int length = chCodeList.getLength();

        boolean isFound = false;
        for (int i = 0; i< length; i++){
            if (isFound) break;

            Node valuteChNode = chCodeList.item(i);
            TextImpl textimpl = (TextImpl)valuteChNode.getFirstChild();
            String chVal = textimpl.getData();

            if (chVal.equalsIgnoreCase(valuteCode)){
                isFound = true;
                Node parent = valuteChNode.getParentNode();
                NodeList nodeList = parent.getChildNodes();
                int paramLength = nodeList.getLength();

                for (int j=0; j<paramLength; j++){
                    Node currentNode = nodeList.item(j);

                    String name = currentNode.getNodeName();
                    Node currentValue = currentNode.getFirstChild();
                    String value = currentValue.getNodeValue();
                    if (name.equalsIgnoreCase("Vname")){
                        answer.name = value;
                    }
                    if (name.equalsIgnoreCase("Vnom")){
                        answer.nom = new BigDecimal(value);
                    }
                    if (name.equalsIgnoreCase("Vcurs")){
                        answer.curs = new BigDecimal(value);
                    }
                    if (name.equalsIgnoreCase("Vcode")){
                        answer.code = Integer.parseInt(value);
                    }
                    if (name.equalsIgnoreCase("VchCode")){
                        answer.chCode = value;
                    }
                }
            }
        }

        return answer;
    }
}
