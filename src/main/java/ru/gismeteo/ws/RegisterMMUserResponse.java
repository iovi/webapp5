
package ru.gismeteo.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RegisterMMUserResult" type="{http://ws.gismeteo.ru/}RegisterResult"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "registerMMUserResult"
})
@XmlRootElement(name = "RegisterMMUserResponse")
public class RegisterMMUserResponse {

    @XmlElement(name = "RegisterMMUserResult", required = true)
    protected RegisterResult registerMMUserResult;

    /**
     * Gets the value of the registerMMUserResult property.
     * 
     * @return
     *     possible object is
     *     {@link RegisterResult }
     *     
     */
    public RegisterResult getRegisterMMUserResult() {
        return registerMMUserResult;
    }

    /**
     * Sets the value of the registerMMUserResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegisterResult }
     *     
     */
    public void setRegisterMMUserResult(RegisterResult value) {
        this.registerMMUserResult = value;
    }

}
