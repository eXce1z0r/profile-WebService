package org.pws.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import org.pws.assets.Randomizer;
import org.pws.dao.PostgreSQLDatabaseService;
import org.pws.logic.WebServiceLogic;
import org.pws.model.ProfileTemplate;
import org.pws.model.DefaultResult;
import org.pws.model.ProfileImpl;
import org.pws.model.ResultTemplate;

public class Test 
{
	public static void main(String[] args)
	{
		List<String> tArr= new ArrayList<>();
		
		tArr.add("abc");
		tArr.add("def");
		tArr.add("ghi");
		//System.out.println(UserProfile.wordsShuffle(tArr));
		
		//String tst= ""+(char)(127)+(char)(128);
		
		//System.out.println(tst);
		
		/*UserProfile a= new UserProfile();
		a.generateAccessKey();*/
		
		/*for(int i= -256; i< 256; i++)
		{
			System.out.println(i+") "+(char)i);
		}*/
		
		/*for(int i= 97; i< 123; i++)
		{
			System.out.print(", '"+(char)i+"'");
		}*/
		
		//System.out.println(Randomizer.getRandomValidChar());
		
		PostgreSQLDatabaseService pGSQLDBTest= new PostgreSQLDatabaseService();
		
		WebServiceLogic logic= new WebServiceLogic(new PostgreSQLDatabaseService("localhost", 5432, "profile_storage_test", "linux_admin", "linux_admin"));
		
		/*
		//download photo by url into folder
		String multi_photo= pGSQLDBTest.downloadProfilePhoto("https://www.gstatic.com/images/branding/product/2x/photos_96dp.png", "D:\\Eclipse_EE_Workspace\\ProfileWebService\\download\\test_url_dir_url.png"); // problem url https://www.xda-developers.com/files/2017/07/Google-Photos-Feature-Image-with-Shadow-Light-Green.png
		System.out.println("Multi photo download url(test1): "+multi_photo);
		
		multi_photo= pGSQLDBTest.downloadProfilePhoto("https://www.xda-developers.com/files/2017/07/Google-Photos-Feature-Image-with-Shadow-Light-Green.png", "D:\\Eclipse_EE_Workspace\\ProfileWebService\\download\\test_problem_url_dir.png");
		System.out.println("Multi photo download problem url(test2): "+multi_photo);
		
		multi_photo= pGSQLDBTest.downloadProfilePhoto("D:\\Photo\\cool\\first_strike_another_tf_oc_by_martrochs.jpg", "D:\\Eclipse_EE_Workspace\\ProfileWebService\\download\\test_url_dir_dir.png");
		System.out.println("Multi photo download dir(test3): "+multi_photo);
		*/		
		
		// ------- TESTS BEGIN ----------
		/*
		String nickname= "&&CNsRa2Z$O>ht[k0I2YgBV2t-$aiL<p+?N.7pc:pH(TPRC5].9:,hBr8t_8";
		String accessKey= "6jpP49;rHkJ#4&n*oZ5&VFXXyoq=4d7t#Z@4?.YY.4xYjeULc$.GE8b(og8>,uO*Vz0FN@1H1Y)isgLIxO2@O+ztI3@WOMl9KmAXO-TENc,]garoER3ffpnZw?Cn<aX8()70<(Y7%E=<h^<Hr*w5CYqmgT(RcvAL?uX5yiLem7Yv4XQF]xntGxsnFJ1pP*sZB($pgqLequ?8NAB:@.6L:$oDRf";
		*/
		
		String nickname= "1^NgwD>,F@=G26M[AYQ.0,]L4*DdZ>MtRPUW2EScy,,Lc6BvwEQtc[W]y_12";
		String accessKey= "<T+GDZw<6jLnOtaet&gaPht&LNqZ59V,*Hu(1+f3>Zz-&xp8oX%RO?V4w?W)rxdJej.hmuv,?KD:cZXX;c7LA>jcQ@BW#5F:PB>Yl&M6mC33x8T51)g;E1D0)q*qYYnx4HCR*zQ?QZJJ8LI<Dkf)c=WQ13>0f].;8Wa:qTi;ec+wQpU[*ut,Gb.^P3]Q)ov+CnbpsdODHlX,Nd)H7TCYyHau:OizN>G1B4@J-RhDsA[,W";
		
		
		/*
		String nickname= "P=q%V-]iMB2)e1jq+msOS-qSM>a3ow4jOR5u<ftGD:&jOm22_3";
		String accessKey= ";vT=pq5@rwNOxcm@I=GJ=iL+t9WIX8^QbL:AYP6>pHyeyjjm4$]*NYLcGj=1r*HO$tm:eYN;7R.+cw2N:yE2J]+lQY+3T>]gb%=AUMpy@M^J)]1LjT&El5^0#kW5N0R)d<qnJ[:8ptT)?e14Z4T4ip0$;kW,))+j70wT;Nx4+c#]CAwBb=9>A$>u[TI,8#*eoc(MB$#<J7I*C0A";
		*/
		
		// Profile add TEST BEGIN		
		/*
		ProfileTemplate profile= new ProfileImpl();
		Map<String, Object> profileInfo= new HashMap<>();
		profileInfo.put("username", "testUsername");
		profileInfo.put("surname", "testSurname");
		profileInfo.put("patronymic", "testPatronymic");
		profileInfo.put("email", "testEmail@test.com");
		profileInfo.put("age", 999);
		profileInfo.put("photo", "https://www.xda-developers.com/files/2017/07/Google-Photos-Feature-Image-with-Shadow-Light-Green.png");
		
		profile.setProfileInfo(profileInfo);
		DefaultResult res= logic.addProfile(profile);
		System.out.println("----- Add request result -----");
		System.out.println("Status: "+res.getStatus());
		System.out.println("Info: "+res.getInfo());
		
		Object[] resSet= res.getResultSet();
		if(resSet.length > 0)
		{
			System.out.println("Result: ");
			for(int i= 0; i< resSet.length; i++)
			{
				System.out.println("\t"+resSet[i]);
			}
		}
		*/
		// Profile add TEST END
		
		// Profile get TEST BEGIN
		
		DefaultResult res= logic.getProfileByNickname(nickname, accessKey);
		System.out.println("----- Get request result -----");
		System.out.println("Status: "+res.getStatus());
		System.out.println("Info: "+res.getInfo());
		
		Object[] resultSet= res.getResultSet();
		if(resultSet != null && resultSet.length > 0)
		{
			System.out.println("Result set: ");
			ProfileTemplate profile= (ProfileImpl)resultSet[0];			
			Map<String, Object> profileInfo= profile.getProfileInfo();
			Iterator<Entry<String, Object>>profileInfoEntrySet= profileInfo.entrySet().iterator();
			while(profileInfoEntrySet.hasNext())
			{
				Entry<String, Object> profileEntry= profileInfoEntrySet.next();
				
				System.out.println("\t"+profileEntry.getKey()+": "+profileEntry.getValue());
				
				// test database image quality BEGIN
				if(profileEntry.getKey().equals("photo"))
				{
					Object imgBA= profileEntry.getValue();
					
					if(imgBA != null && imgBA.getClass().getName().equals(byte[].class.getName()))
					{
						try
						{	
							ByteArrayInputStream bAIS= new ByteArrayInputStream((byte[])imgBA);
							
							BufferedImage img= ImageIO.read(bAIS);
							
							ImageIO.write(img, "png", new File("D:\\Eclipse_EE_Workspace\\ProfileWebService\\download\\test.png"));
						
							bAIS.close();
						}
						catch(IOException e)
						{
							e.printStackTrace();
						}
					}
				}
				// test database image quality END
			}
		}
		
		// Profile get TEST END
		
		// Profile edit TEST BEGIN
		/*
		Map<String, Object> profileInfo= new HashMap<>();
		profileInfo.put("username", "testUsername");
		profileInfo.put("surname", "testSurname");
		
		ProfileTemplate profile= new ProfileImpl(profileInfo);
		
		DefaultResult res= logic.editProfileByNickname(nickname, accessKey, profile);
		
		System.out.println("----- Edit request result -----");
		System.out.println("Status: "+res.getStatus());
		System.out.println("Info: "+res.getInfo());
		
		Object[] resultSet= res.getResultSet();
		if(resultSet != null && resultSet.length > 0)
		{
			System.out.println("Result set: ");
			ProfileTemplate resProfile= (ProfileImpl)resultSet[0];			
			Map<String, Object> resProfileInfo= resProfile.getProfileInfo();
			Iterator<Entry<String, Object>>profileInfoEntrySet= resProfileInfo.entrySet().iterator();
			while(profileInfoEntrySet.hasNext())
			{
				Entry<String, Object> profileEntry= profileInfoEntrySet.next();
				
				System.out.println(profileEntry.getKey()+": "+profileEntry.getValue());
			}
		}
		*/
		// Profile edit TEST END
		
		// Profile remove TEST BEGIN
		/*
		System.out.println("----- Remove request result -----");
		boolean res= logic.removeProfileByNickname(nickname, accessKey);
		System.out.println("Remove result: "+res);
		*/
		// Profile remove TEST END
		
		// ------- TESTS END ----------
		
		/*Map<String, Object> params= new HashMap<>();
		params.put("username", "testUsername");
		params.put("surname", "testSurname");
		params.put("patronymic", "testPatronymic");
		params.put("email", "testEmail@test.com");
		params.put("photo", "photoUrl");
		params.put("age", 999);
		ResultTemplate res= pGSQLDBTest.addProfile(new ProfileImpl(params));		
		System.out.println("reqStatus: "+res.getStatus()+"\ninfo: "+res.getInfo()+"\nnickname: "+res.getResultSet()[0]+"\naccess_key: "+res.getResultSet()[1]);*/
		
		/*
		String userNickname= "@V<@piP[0y);D$p?Qj>^;mlHR+dc,n?#ety=Hu+:Q4L[Osl6_4";
		String userAccessKey= "acdHyr^k%Kb7hRk>P*dMy%AZxYf&XOgrCOTuQ%i^P-T9%$w1k-w@iS$tQd#;Ju54MUi&<F<n*3BLhUab()h@qPp;+BUz0tENt.nm=vz=##K1Q.Ty@+gQ-$2nK;k;.DZ%#^H6m8CL[%CAz;DqjnUBvO;:1>tC5vP@LvmBf7n4vemg-k:8vqOrisJ0nsEvTeL3S((r>Sy03l[+)+,kBVx#Lq3ZHbFG7IW2&$all:H57CVl[ZXsA[4]#[(t8E8";
		*/
		/*
		String userNickname= "P=q%V-]iMB2)e1jq+msOS-qSM>a3ow4jOR5u<ftGD:&jOm22_3";
		String userAccessKey= ";vT=pq5@rwNOxcm@I=GJ=iL+t9WIX8^QbL:AYP6>pHyeyjjm4$]*NYLcGj=1r*HO$tm:eYN;7R.+cw2N:yE2J]+lQY+3T>]gb%=AUMpy@M^J)]1LjT&El5^0#kW5N0R)d<qnJ[:8ptT)?e14Z4T4ip0$;kW,))+j70wT;Nx4+c#]CAwBb=9>A$>u[TI,8#*eoc(MB$#<J7I*C0A";
		*/
		
		/*Map<String, Object> permissions= new HashMap<>();
		permissions.put("global_access_flag", 1);
		permissions.put("edit_flag", true);
		permissions.put("remove_flag", true);
		System.out.println(pGSQLDBTest.editProfilePermissions(userNickname, userAccessKey, permissions));*/
		
		
		/*DefaultResult res= pGSQLDBTest.getProfileByNickname(userNickname, userAccessKey);
		System.out.println("getted profile: "+res.getInfo());
		
		ProfileTemplate profile= (ProfileImpl)res.getResultSet()[0];
		System.out.println(profile.getProfileInfo());*/
		
		/*Map<String, Object> params= new HashMap<>();
		params.put("username", "testUsername_edited");
		params.put("surname", "testSurname_edited");
		params.put("patronymic", "testPatronymic_edited");
		params.put("tabata", "testPatronymic_edited");
		ResultTemplate res= pGSQLDBTest.editProfileByNickname(userNickname, userAccessKey, new ProfileImpl(params));
		System.out.println("status: "+res.getStatus()+"\ninfo: "+res.getInfo());*/
		
		//System.out.println(pGSQLDBTest.removeProfileByNickname(userNickname, userAccessKey));
		
		/*Object a= new String();
		System.out.println(a instanceof String);*/
		
		/*Object b= 'c';		
		System.out.println(b instanceof String);*/
	}
}
