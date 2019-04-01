
package org.pws.client.service_interaction_assets;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TestProfilesWebStorage", targetNamespace = "http://www.testprofilesstorage.com")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TestProfilesWebStorage {


    /**
     * 
     * @param profile
     * @return
     *     returns org.pws.client.service_interaction_assets.DefaultResult
     */
    @WebMethod(action = "add_profile")
    @WebResult(name = "AddResult", targetNamespace = "")
    @RequestWrapper(localName = "addProfile", targetNamespace = "http://www.testprofilesstorage.com", className = "org.pws.client.service_interaction_assets.AddProfile")
    @ResponseWrapper(localName = "addProfileResponse", targetNamespace = "http://www.testprofilesstorage.com", className = "org.pws.client.service_interaction_assets.AddProfileResponse")
    @Action(input = "add_profile", output = "http://www.testprofilesstorage.com/TestProfilesWebStorage/addProfileResponse")
    public DefaultResult addProfile(
        @WebParam(name = "profile", targetNamespace = "")
        ProfileImpl profile);

    /**
     * 
     * @param nickame
     * @param key
     * @return
     *     returns org.pws.client.service_interaction_assets.DefaultResult
     */
    @WebMethod(action = "get_profile_by_nickname")
    @WebResult(name = "Profile", targetNamespace = "")
    @RequestWrapper(localName = "getProfileByNickname", targetNamespace = "http://www.testprofilesstorage.com", className = "org.pws.client.service_interaction_assets.GetProfileByNickname")
    @ResponseWrapper(localName = "getProfileByNicknameResponse", targetNamespace = "http://www.testprofilesstorage.com", className = "org.pws.client.service_interaction_assets.GetProfileByNicknameResponse")
    @Action(input = "get_profile_by_nickname", output = "http://www.testprofilesstorage.com/TestProfilesWebStorage/getProfileByNicknameResponse")
    public DefaultResult getProfileByNickname(
        @WebParam(name = "nickame", targetNamespace = "")
        String nickame,
        @WebParam(name = "key", targetNamespace = "")
        String key);

    /**
     * 
     * @param profile
     * @param nickname
     * @param key
     * @return
     *     returns org.pws.client.service_interaction_assets.DefaultResult
     */
    @WebMethod(action = "edit_profile_by_nickname")
    @WebResult(name = "EditResult", targetNamespace = "")
    @RequestWrapper(localName = "editProfileByNickname", targetNamespace = "http://www.testprofilesstorage.com", className = "org.pws.client.service_interaction_assets.EditProfileByNickname")
    @ResponseWrapper(localName = "editProfileByNicknameResponse", targetNamespace = "http://www.testprofilesstorage.com", className = "org.pws.client.service_interaction_assets.EditProfileByNicknameResponse")
    @Action(input = "edit_profile_by_nickname", output = "http://www.testprofilesstorage.com/TestProfilesWebStorage/editProfileByNicknameResponse")
    public DefaultResult editProfileByNickname(
        @WebParam(name = "nickname", targetNamespace = "")
        String nickname,
        @WebParam(name = "key", targetNamespace = "")
        String key,
        @WebParam(name = "profile", targetNamespace = "")
        ProfileImpl profile);

    /**
     * 
     * @param nickname
     * @param key
     * @return
     *     returns boolean
     */
    @WebMethod(action = "remove_profile_by_nickname")
    @WebResult(name = "RemoveStatus", targetNamespace = "")
    @RequestWrapper(localName = "removeProfileByNickname", targetNamespace = "http://www.testprofilesstorage.com", className = "org.pws.client.service_interaction_assets.RemoveProfileByNickname")
    @ResponseWrapper(localName = "removeProfileByNicknameResponse", targetNamespace = "http://www.testprofilesstorage.com", className = "org.pws.client.service_interaction_assets.RemoveProfileByNicknameResponse")
    @Action(input = "remove_profile_by_nickname", output = "http://www.testprofilesstorage.com/TestProfilesWebStorage/removeProfileByNicknameResponse")
    public boolean removeProfileByNickname(
        @WebParam(name = "nickname", targetNamespace = "")
        String nickname,
        @WebParam(name = "key", targetNamespace = "")
        String key);

}
