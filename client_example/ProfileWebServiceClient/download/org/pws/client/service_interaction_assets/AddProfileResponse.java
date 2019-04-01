
package org.pws.client.service_interaction_assets;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addProfileResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addProfileResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddResult" type="{http://www.testprofilesstorage.com}defaultResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addProfileResponse", propOrder = {
    "addResult"
})
public class AddProfileResponse {

    @XmlElement(name = "AddResult")
    protected DefaultResult addResult;

    /**
     * Gets the value of the addResult property.
     * 
     * @return
     *     possible object is
     *     {@link DefaultResult }
     *     
     */
    public DefaultResult getAddResult() {
        return addResult;
    }

    /**
     * Sets the value of the addResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultResult }
     *     
     */
    public void setAddResult(DefaultResult value) {
        this.addResult = value;
    }

}
