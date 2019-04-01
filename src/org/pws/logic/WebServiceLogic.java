package org.pws.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import javax.imageio.ImageIO;

import org.pws.dao.DatabaseServiceTemplate;
import org.pws.model.DefaultResult;
import org.pws.model.ProfileImpl;
import org.pws.model.ProfileTemplate;
import org.pws.model.ResultTemplate;

public class WebServiceLogic 
{
	private DatabaseServiceTemplate databaseService= null;
	
	public WebServiceLogic(DatabaseServiceTemplate databaseService)
	{
		this.databaseService= databaseService;
	}
	
	public DefaultResult addProfile(ProfileTemplate profile)
	{
		//rewrite profile
		Map<String, Object> newProfile= profile.getProfileInfo();
		if(newProfile.containsKey("photo"))
		{
			Object photoUrl= null;
			if((photoUrl= newProfile.get("photo")) instanceof String)
			{
				InputStream photoIS= downloadProfilePhoto((String)photoUrl);
				newProfile.put("photo", photoIS);
			}
			
			/* remade photo loader to url/dir -> inputStream and move to logic. Call this method here as parameter set
			 * dir/url as result return inputStream that rewrite String url/dir into hashMap by key
			*/
		}
		return databaseService.addProfile(profile);
	}
	
	public DefaultResult getProfileByNickname(String nickname, String accessKey)
	{
		return databaseService.getProfileByNickname(nickname, accessKey);
	}
	
	public DefaultResult editProfileByNickname(String nickname, String accessKey, ProfileTemplate profile)
	{
		return databaseService.editProfileByNickname(nickname, accessKey, profile);
	}
	
	public boolean removeProfileByNickname(String nickname, String accessKey)
	{
		return databaseService.removeProfileByNickname(nickname, accessKey);
	}
	
	private InputStream downloadProfilePhoto(String inputUrl)
	{
		InputStream iS= null;
		try 
		{
			URLConnection urlConnection= new URL(inputUrl).openConnection();
			urlConnection.setConnectTimeout(1000);
			urlConnection.addRequestProperty("User-Agent", "Chrome");
			iS= urlConnection.getInputStream();
		} 
		catch (MalformedURLException e) 
		{
			try 
			{
				iS= new FileInputStream(new File(inputUrl));
			} 
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		if(iS != null)
		{
			return iS;
			/*try
			{
				BufferedImage img= ImageIO.read(iS);
				ImageIO.write(img, "png", new File(outputPath));
				return outputPath;
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					iS.close();
				} 
				catch (IOException e) 
				{
					
				}
			}*/
		}
		
		return null;
	}
}
