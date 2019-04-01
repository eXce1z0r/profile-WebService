package org.pws.dao;

import org.pws.model.DefaultResult;
import org.pws.model.ProfileImpl;
import org.pws.model.ProfileTemplate;
import org.pws.model.ResultTemplate;

public interface DatabaseServiceTemplate 
{
	boolean connect();
	
	DefaultResult addProfile(ProfileTemplate profile);
	
	DefaultResult getProfileByNickname(String nickname, String accessKey);
	
	DefaultResult editProfileByNickname(String nickname, String accessKey, ProfileTemplate profile);
	
	boolean removeProfileByNickname(String nickname, String accessKey);
}
