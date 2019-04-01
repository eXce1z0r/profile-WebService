
package org.pws.client.service_interaction_assets;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editProfileByNicknameResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editProfileByNicknameResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EditResult" type="{http://www.testprofilesstorage.com}defaultResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editProfileByNicknameResponse", propOrder = {
    "editResult"
})
public class EditProfileByNicknameResponse {

    @XmlElement(name = "EditResult")
    protected DefaultResult editResult;

    /**
     * Gets the value of the editResult property.
     * 
     * @return
     *     possible object is
     *     {@link DefaultResult }
     *     
     */
    public DefaultResult getEditResult() {
        return editResult;
    }

    /**
     * Sets the value of the editResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultResult }
     *     
     */
    public void setEditResult(DefaultResult value) {
        this.editResult = value;
    }

}
