
package org.pws.client.service_interaction_assets;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for removeProfileByNicknameResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="removeProfileByNicknameResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RemoveStatus" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeProfileByNicknameResponse", propOrder = {
    "removeStatus"
})
public class RemoveProfileByNicknameResponse {

    @XmlElement(name = "RemoveStatus")
    protected boolean removeStatus;

    /**
     * Gets the value of the removeStatus property.
     * 
     */
    public boolean isRemoveStatus() {
        return removeStatus;
    }

    /**
     * Sets the value of the removeStatus property.
     * 
     */
    public void setRemoveStatus(boolean value) {
        this.removeStatus = value;
    }

}
