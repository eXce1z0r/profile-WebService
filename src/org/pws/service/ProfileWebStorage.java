package org.pws.service;

import javax.jws.WebService;

import org.pws.dao.PostgreSQLDatabaseService;
import org.pws.logic.WebServiceLogic;
import org.pws.model.DefaultResult;
import org.pws.model.ProfileImpl;
import org.pws.model.ProfileTemplate;
import org.pws.model.ResultTemplate;

@WebService(endpointInterface= "org.pws.service.ProfileWebStorageTemplate", portName= "TestProfilesWebStoragePort", serviceName= "TestProfilesWebStorageService") // endpointInterface - used for binding WebService interface with all it's annotations to it's implementation class. serviceName - represents service name at url request.
public class ProfileWebStorage implements ProfileWebStorageTemplate 
{
	private WebServiceLogic logic= new WebServiceLogic(new PostgreSQLDatabaseService("localhost", 5432, "profile_storage_test", "linux_admin", "linux_admin"));
	
	public ProfileWebStorage()
	{
		System.setProperty("javax.xml.soap.SAAJMetaFactory", "com.sun.xml.messaging.saaj.soap.SAAJMetaFactoryImpl");
	}
	
	@Override
	public DefaultResult addProfile(ProfileImpl profile) 
	{
		return logic.addProfile(profile);
	}

	@Override
	public DefaultResult getProfileByNickname(String nickname, String accessKey) 
	{
		return logic.getProfileByNickname(nickname, accessKey);
	}

	@Override
	public DefaultResult editProfileByNickname(String nickname, String accessKey, ProfileImpl profile) 
	{
		return logic.editProfileByNickname(nickname, accessKey, profile);
	}

	@Override
	public boolean removeProfileByNickname(String nickname, String accessKey) 
	{
		return logic.removeProfileByNickname(nickname, accessKey);
	}

}
