
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
 *         &lt;element name="RegisterHHUserResult" type="{http://ws.gismeteo.ru/}RegisterResult"/>
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
    "registerHHUserResult"
})
@XmlRootElement(name = "RegisterHHUserResponse")
public class RegisterHHUserResponse {

    @XmlElement(name = "RegisterHHUserResult", required = true)
    protected RegisterResult registerHHUserResult;

    /**
     * Gets the value of the registerHHUserResult property.
     * 
     * @return
     *     possible object is
     *     {@link RegisterResult }
     *     
     */
    public RegisterResult getRegisterHHUserResult() {
        return registerHHUserResult;
    }

    /**
     * Sets the value of the registerHHUserResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegisterResult }
     *     
     */
    public void setRegisterHHUserResult(RegisterResult value) {
        this.registerHHUserResult = value;
    }

}
