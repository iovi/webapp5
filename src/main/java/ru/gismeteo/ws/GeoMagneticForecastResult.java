
package ru.gismeteo.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeoMagneticForecastResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeoMagneticForecastResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="result" type="{http://ws.gismeteo.ru/}ServiceResult"/>
 *         &lt;element name="data" type="{http://ws.gismeteo.ru/}ArrayOfGeoMagneticForecast" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeoMagneticForecastResult", propOrder = {
    "result",
    "data"
})
public class GeoMagneticForecastResult {

    @XmlElement(required = true)
    protected ServiceResult result;
    protected ArrayOfGeoMagneticForecast data;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceResult }
     *     
     */
    public ServiceResult getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceResult }
     *     
     */
    public void setResult(ServiceResult value) {
        this.result = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGeoMagneticForecast }
     *     
     */
    public ArrayOfGeoMagneticForecast getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGeoMagneticForecast }
     *     
     */
    public void setData(ArrayOfGeoMagneticForecast value) {
        this.data = value;
    }

}
