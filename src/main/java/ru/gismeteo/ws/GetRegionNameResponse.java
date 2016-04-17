
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
 *         &lt;element name="GetRegionNameResult" type="{http://ws.gismeteo.ru/}GetNameResult"/>
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
    "getRegionNameResult"
})
@XmlRootElement(name = "GetRegionNameResponse")
public class GetRegionNameResponse {

    @XmlElement(name = "GetRegionNameResult", required = true)
    protected GetNameResult getRegionNameResult;

    /**
     * Gets the value of the getRegionNameResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetNameResult }
     *     
     */
    public GetNameResult getGetRegionNameResult() {
        return getRegionNameResult;
    }

    /**
     * Sets the value of the getRegionNameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetNameResult }
     *     
     */
    public void setGetRegionNameResult(GetNameResult value) {
        this.getRegionNameResult = value;
    }

}
