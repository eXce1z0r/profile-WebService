package org.pws.client;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.pws.client.service_interaction_assets.DefaultResult;
import org.pws.client.service_interaction_assets.ProfileImpl;
import org.pws.client.service_interaction_assets.ProfileImpl.ProfileInfo;
import org.pws.client.service_interaction_assets.ProfileImpl.ProfileInfo.Entry;
import org.pws.client.service_interaction_assets.TestProfilesWebStorage;
import org.pws.client.service_interaction_assets.TestProfilesWebStorageService;

public class ProfileWebServiceTestClient
{
	public static void main(String[] args)
	{
		TestProfilesWebStorageService service= new TestProfilesWebStorageService();
		TestProfilesWebStorage servicePort= service.getTestProfilesWebStoragePort();
		
		/*
		String nickname= "&&CNsRa2Z$O>ht[k0I2YgBV2t-$aiL<p+?N.7pc:pH(TPRC5].9:,hBr8t_8";
		String accessKey= "6jpP49;rHkJ#4&n*oZ5&VFXXyoq=4d7t#Z@4?.YY.4xYjeULc$.GE8b(og8>,uO*Vz0FN@1H1Y)isgLIxO2@O+ztI3@WOMl9KmAXO-TENc,]garoER3ffpnZw?Cn<aX8()70<(Y7%E=<h^<Hr*w5CYqmgT(RcvAL?uX5yiLem7Yv4XQF]xntGxsnFJ1pP*sZB($pgqLequ?8NAB:@.6L:$oDRf";
		*/
		
		/*
		String nickname= "1^NgwD>,F@=G26M[AYQ.0,]L4*DdZ>MtRPUW2EScy,,Lc6BvwEQtc[W]y_12";
		String accessKey= "<T+GDZw<6jLnOtaet&gaPht&LNqZ59V,*Hu(1+f3>Zz-&xp8oX%RO?V4w?W)rxdJej.hmuv,?KD:cZXX;c7LA>jcQ@BW#5F:PB>Yl&M6mC33x8T51)g;E1D0)q*qYYnx4HCR*zQ?QZJJ8LI<Dkf)c=WQ13>0f].;8Wa:qTi;ec+wQpU[*ut,Gb.^P3]Q)ov+CnbpsdODHlX,Nd)H7TCYyHau:OizN>G1B4@J-RhDsA[,W";
		*/
		
		// ------- TESTS BEGIN ----------
		// Profile add TEST BEGIN		
		
		ProfileImpl profile= new ProfileImpl();
		ProfileInfo profileInfo= new ProfileInfo();
		List<Entry> profileInfoEntry= profileInfo.getEntry();
			
		Entry profileInfoParam= new Entry();
		profileInfoParam.setKey("username");
		profileInfoParam.setValue("testUsername");
		profileInfoEntry.add(profileInfoParam);
				
		profileInfoParam= new Entry();
		profileInfoParam.setKey("surname");
		profileInfoParam.setValue("testSurname");
		profileInfoEntry.add(profileInfoParam);
				
		profileInfoParam= new Entry();
		profileInfoParam.setKey("patronymic");
		profileInfoParam.setValue("testPatronymic");
		profileInfoEntry.add(profileInfoParam);
		
		profileInfoParam= new Entry();
		profileInfoParam.setKey("email");
		profileInfoParam.setValue("testEmail@test.com");
		profileInfoEntry.add(profileInfoParam);
				
		profileInfoParam= new Entry();
		profileInfoParam.setKey("age");
		profileInfoParam.setValue(999);
		profileInfoEntry.add(profileInfoParam);
				
		profileInfoParam= new Entry();
		profileInfoParam.setKey("photo");
		profileInfoParam.setValue("https://www.xda-developers.com/files/2017/07/Google-Photos-Feature-Image-with-Shadow-Light-Green.png");
		profileInfoEntry.add(profileInfoParam);
				
		profile.setProfileInfo(profileInfo);
		DefaultResult res= servicePort.addProfile(profile);
		System.out.println("----- Add request result -----");
		System.out.println("Status: "+res.isStatus());
		System.out.println("Info: "+res.getInfo());
				
		List<Object> resSet= res.getResultSet();
		if(resSet.size() > 0)
		{
			System.out.println("Result: ");
			for(int i= 0; i< resSet.size(); i++)
			{
				System.out.println("\t"+resSet.get(i));
			}
		}
		
		// Profile add TEST END
				
		// Profile get TEST BEGIN
		/*
		DefaultResult res= servicePort.getProfileByNickname(nickname, accessKey);
		System.out.println("----- Get request result -----");
		System.out.println("Status: "+res.isStatus());
		System.out.println("Info: "+res.getInfo());
				
		List<Object> resultSet= res.getResultSet();
		if(resultSet != null && resultSet.size() > 0)
		{
			System.out.println("Result set: ");
			ProfileImpl profile= (ProfileImpl)resultSet.get(0);			
			ProfileInfo profileInfo= profile.getProfileInfo();
			Iterator<Entry>profileInfoEntrySet= profileInfo.getEntry().iterator();
			while(profileInfoEntrySet.hasNext())
			{
				Entry profileEntry= profileInfoEntrySet.next();
										
				// test database image quality BEGIN
				if(profileEntry.getKey().equals("photo"))
				{
					boolean resFlag= false;
					Object imgBA= profileEntry.getValue();
					
					if(imgBA != null && imgBA.getClass().getName().equals(byte[].class.getName()))
					{
						try
						{	
							ByteArrayInputStream bAIS= new ByteArrayInputStream((byte[])imgBA);
							
							BufferedImage img= ImageIO.read(bAIS);
							
							resFlag= ImageIO.write((BufferedImage)img, "png", new File("D:\\Eclipse_EE_Workspace\\ProfileWebServiceClient\\download\\test.png"));
							
							bAIS.close();
						}
						catch(IOException e)
						{
							e.printStackTrace();
						}
					}
					System.out.println("\t"+profileEntry.getKey()+"[status: "+resFlag+"]: "+profileEntry.getValue());
				}
				else
				{
					System.out.println("\t"+profileEntry.getKey()+": "+profileEntry.getValue());
				}
				// test database image quality END
			}
		}
		*/
		// Profile get TEST END
				
		// Profile edit TEST BEGIN
		/*
		ProfileImpl profile= new ProfileImpl();		
		ProfileInfo profileInfo= new ProfileInfo();
		
		List<Entry> profileInfoEntry= profileInfo.getEntry();
		
		Entry profileInfoParam= new Entry();
		profileInfoParam.setKey("username");
		profileInfoParam.setValue("testUsername");
		profileInfoEntry.add(profileInfoParam);
		
		profileInfoParam= new Entry();
		profileInfoParam.setKey("surname");
		profileInfoParam.setValue("testSurname");
		profileInfoEntry.add(profileInfoParam);
		
		profile.setProfileInfo(profileInfo);
		
		DefaultResult res= servicePort.editProfileByNickname(nickname, accessKey, profile);
		
		System.out.println("----- Edit request result -----");
		System.out.println("Status: "+res.isStatus());
		System.out.println("Info: "+res.getInfo());
				
		List<Object> resultSet= res.getResultSet();
		if(resultSet != null && resultSet.size() > 0)
		{
			System.out.println("Result set: ");
			ProfileImpl resProfile= (ProfileImpl)resultSet.get(0);			
			ProfileInfo resProfileInfo= resProfile.getProfileInfo();
			Iterator<Entry>profileInfoEntrySet= resProfileInfo.getEntry().iterator();
			while(profileInfoEntrySet.hasNext())
			{
				Entry profileEntry= profileInfoEntrySet.next();
				
				System.out.println(profileEntry.getKey()+": "+profileEntry.getValue());
			}
		}
		*/
		// Profile edit TEST END
				
		// Profile remove TEST BEGIN
		/*
		System.out.println("----- Remove request result -----");
		boolean res= servicePort.removeProfileByNickname(nickname, accessKey);
		System.out.println("Remove result: "+res);
		*/
		// Profile remove TEST END
				
		// ------- TESTS END ----------
	}
}
