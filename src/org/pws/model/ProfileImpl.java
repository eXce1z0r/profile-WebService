package org.pws.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.pws.assets.Randomizer;

@XmlRootElement(name="Profile") // name - responsible for setting name of main class at xml file.
public class ProfileImpl implements ProfileTemplate
{	
	private String nickname= null;
	private String accessKey= null;
	
	private Map<String, Object> profileInfo= new HashMap<>();
	
	public ProfileImpl()
	{
		generateAccessKey();
	}
	
	public ProfileImpl(Map<String, Object> params) 
	{
		//generateNickname(id);
		generateAccessKey();
		
		profileInfo= params;
	}
	
	public ProfileImpl(String nickname, String accessKey) 
	{
		this.nickname= nickname;
		this.accessKey= accessKey;
	}
	
	public ProfileImpl(String nickname, String accessKey, Map<String, Object> params) 
	{
		this.nickname= nickname;
		this.accessKey= accessKey;
		
		profileInfo= params;
	}

	@XmlElement(required= true, nillable= true) // required - responsible for minOccurs value at SOAP Web Service method call. nillable - used for understanding that this parameter can or not be nullable.
	@Override
	public String getNickname() 
	{
		return nickname;
	}
	
	@Override
	public void generateNickname(Object... profilesFeatures)
	{
		int randomWordSize= Randomizer.getRandomValueInRange(32, 64);
		StringBuilder randomWord= new StringBuilder();
		for(int i= 0; i< randomWordSize; i++)
		{
			randomWord.append(Randomizer.getRandomValidCharForNickname());
		}
		randomWord.append("_");
		
		for(Object profilesFeature: profilesFeatures)
		{
			randomWord.append(profilesFeature);
		}
		
		nickname= randomWord.toString();
	}
	
	@XmlElement(required= true, nillable= true)
	@Override
	public String getAccessKey() 
	{
		return accessKey;
	}
	
	private void generateAccessKey()
	{
		int randomWordSize= Randomizer.getRandomValueInRange(128, 256); // generate future word size based on random value in range (16, 64)
		StringBuilder randomWord= new StringBuilder();
		for(int i= 0; i< randomWordSize; i++)
		{
			randomWord.append(Randomizer.getRandomValidChar());
		}
		
		accessKey= randomWord.toString();
	}

	@Override
	public Map<String, Object> getProfileInfo() 
	{
		return profileInfo;
	}
	
	@Override
	public void setProfileInfo(Map<String, Object> profileInfo)
	{
		this.profileInfo= profileInfo;
	}
}
