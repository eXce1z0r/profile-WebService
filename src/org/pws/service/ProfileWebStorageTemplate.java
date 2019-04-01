package org.pws.service;

import javax.annotation.security.RolesAllowed;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.pws.model.DefaultResult;
import org.pws.model.ProfileImpl;
import org.pws.model.ProfileTemplate;
import org.pws.model.ResultTemplate;

@WebService(name= "TestProfilesWebStorage", targetNamespace= "http://www.testprofilesstorage.com") // name - responsible for portType name. targetNamespace - specify location of classes for current service, have same functions as package at java. 
public interface ProfileWebStorageTemplate
{
	@WebMethod(action= "add_profile", operationName= "addProfile", exclude= false) // action - responsible for operation input wsam:Action and operation soap:operation soapAction parameter names. operationName - responsible for message/operation name parameter. exclude - responsible for visibility this method as service method. 
	@WebResult(name= "AddResult")
	DefaultResult addProfile(@WebParam(name= "profile") ProfileImpl profile);
	
	@WebMethod(action= "get_profile_by_nickname", operationName= "getProfileByNickname", exclude= false) // action - responsible for operation input wsam:Action and operation soap:operation soapAction parameter names. operationName - responsible for message/operation name parameter. exclude - responsible for visibility this method as service method.
	@WebResult(name= "Profile")
	//@RolesAllowed("USER")
	DefaultResult getProfileByNickname(@WebParam(name= "nickame") String nickname, @WebParam(name= "key") String accessKey);
	
	@WebMethod(action= "edit_profile_by_nickname", operationName= "editProfileByNickname", exclude= false) // action - responsible for operation input wsam:Action and operation soap:operation soapAction parameter names. operationName - responsible for message/operation name parameter. exclude - responsible for visibility this method as service method.
	@WebResult(name="EditResult")
	DefaultResult editProfileByNickname(@WebParam(name= "nickname") String nickname, @WebParam(name= "key") String accessKey, @WebParam(name= "profile") ProfileImpl profile);
	
	@WebMethod(action= "remove_profile_by_nickname",operationName= "removeProfileByNickname", exclude= false) // action - responsible for operation input wsam:Action and operation soap:operation soapAction parameter names. operationName - responsible for message/operation name parameter. exclude - responsible for visibility this method as service method.
	@WebResult(name="RemoveStatus")
	boolean removeProfileByNickname(@WebParam(name= "nickname") String nickname, @WebParam(name= "key") String accessKey);
}
