package org.pws.model;

import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
public interface ProfileTemplate
{	
	public String getNickname();
	
	public void generateNickname(Object... features);	// nicknames are generated randomly, so that it is proposed to add some distinctive features. Features will be added after symbol '_'. In this program, as this feature used id of user in the database.
	
	public String getAccessKey();
	
	public Map<String, Object> getProfileInfo();
	
	public void setProfileInfo(Map<String, Object> profileInfo);
}
