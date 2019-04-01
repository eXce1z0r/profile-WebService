package org.pws.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.pws.client.service_interaction_assets.DefaultResult;
import org.pws.client.service_interaction_assets.ProfileImpl;
import org.pws.client.service_interaction_assets.ProfileImpl.ProfileInfo;
import org.pws.client.service_interaction_assets.ProfileImpl.ProfileInfo.Entry;
import org.pws.client.service_interaction_assets.TestProfilesWebStorage;
import org.pws.client.service_interaction_assets.TestProfilesWebStorageService;

public class TestLauncher 
{
	public static void main(String[] args)
	{
		TestProfilesWebStorageService testService= new TestProfilesWebStorageService();
		System.out.println(testService.getServiceName());
		
		TestProfilesWebStorage service= testService.getTestProfilesWebStoragePort();
		
		/*ADD PROFILE TEST BEGIN*/
		/*ProfileImpl profile = new ProfileImpl();
		
		ProfileInfo profileInfo= new ProfileInfo();
		List<Entry> profileInfoEntryArray= profileInfo.getEntry();
		
		Entry infoParamUsername= new Entry();		
		infoParamUsername.setKey("username");
		infoParamUsername.setValue("testUsername");	
		profileInfoEntryArray.add(infoParamUsername);
		
		Entry infoParamSurname= new Entry();
		infoParamSurname.setKey("surname");
		infoParamSurname.setValue("testSurname");
		profileInfoEntryArray.add(infoParamSurname);
		
		Entry infoParamPatronymic= new Entry();
		infoParamPatronymic.setKey("patronymic");
		infoParamPatronymic.setValue("testPatronymic");
		profileInfoEntryArray.add(infoParamPatronymic);
		
		Entry infoParamEmail= new Entry();
		infoParamEmail.setKey("email");
		infoParamEmail.setValue("testEmail@test.com");
		profileInfoEntryArray.add(infoParamEmail);
		
		Entry infoParamPhoto= new Entry();
		infoParamPhoto.setKey("photo");
		infoParamPhoto.setValue("protoURL");
		profileInfoEntryArray.add(infoParamPhoto);
		
		Entry infoParamAge= new Entry();
		infoParamAge.setKey("age");
		infoParamAge.setValue("999");
		profileInfoEntryArray.add(infoParamAge);
		
		profile.setProfileInfo(profileInfo);
		DefaultResult res= service.addProfile(profile);
		
		System.out.println("Info: "+res.getInfo());
		System.out.println("Status: "+res.isStatus());
		System.out.println("Result set: ");
		List<Object> resSet= res.getResultSet();
		for(int i= 0; i< resSet.size(); i++)
		{
			switch(i)
			{
			case 0:
				System.out.print("\tnickname: ");
				break;
			case 1: 
				System.out.print("\tusername: ");
				break;
			}
			System.out.println(resSet.get(i));
		}*/
		/*ADD PROFILE TEST END*/
		
		
		/*GET PROFILE TEST BEGIN*/
		String nickname= "&&CNsRa2Z$O>ht[k0I2YgBV2t-$aiL<p+?N.7pc:pH(TPRC5].9:,hBr8t_8";
		String accessKey= "6jpP49;rHkJ#4&n*oZ5&VFXXyoq=4d7t#Z@4?.YY.4xYjeULc$.GE8b(og8>,uO*Vz0FN@1H1Y)isgLIxO2@O+ztI3@WOMl9KmAXO-TENc,]garoER3ffpnZw?Cn<aX8()70<(Y7%E=<h^<Hr*w5CYqmgT(RcvAL?uX5yiLem7Yv4XQF]xntGxsnFJ1pP*sZB($pgqLequ?8NAB:@.6L:$oDRf";
		
		DefaultResult res= service.getProfileByNickname(nickname, accessKey);
		
		System.out.println("Info: "+res.getInfo());
		System.out.println("Status: "+res.isStatus());
		
		if(res.isStatus())
		{
			System.out.println("Result set: ");
			
			ProfileImpl profile= (ProfileImpl)res.getResultSet().get(0);
			
			Iterator<Entry> profileInfo= profile.getProfileInfo().getEntry().iterator();
			while(profileInfo.hasNext())
			{
				Entry infoPart= profileInfo.next();
				System.out.println("\t"+infoPart.getKey()+": "+infoPart.getValue());
			}
		}
		/*GET PROFILE TEST END*/
		
		
		/*EDIT PROFILE TEST BEGIN*/
		/*String nickname= "P=q%V-]iMB2)e1jq+msOS-qSM>a3ow4jOR5u<ftGD:&jOm22_3";
		String access_key= ";vT=pq5@rwNOxcm@I=GJ=iL+t9WIX8^QbL:AYP6>pHyeyjjm4$]*NYLcGj=1r*HO$tm:eYN;7R.+cw2N:yE2J]+lQY+3T>]gb%=AUMpy@M^J)]1LjT&El5^0#kW5N0R)d<qnJ[:8ptT)?e14Z4T4ip0$;kW,))+j70wT;Nx4+c#]CAwBb=9>A$>u[TI,8#*eoc(MB$#<J7I*C0A";
		
		ProfileImpl profile= new ProfileImpl();
		ProfileInfo profileInfo= new ProfileInfo();
		List<Entry> profileInfoEntrySet= profileInfo.getEntry();
		

		 Entry profileInfoParameter= new Entry();		
		profileInfoParameter.setKey("username");
		profileInfoParameter.setValue("testUsername_edit");
		profileInfoEntrySet.add(profileInfoParameter);
		
		profileInfoParameter= new Entry();
		profileInfoParameter.setKey("patronymic");
		profileInfoParameter.setValue("testPatronymic_edit");
		profileInfoEntrySet.add(profileInfoParameter);
		
		profile.setProfileInfo(profileInfo);
		DefaultResult res= service.editProfileByNickname(nickname, access_key, profile);
		
		System.out.println("Info: "+res.getInfo());
		System.out.println("Status: "+res.isStatus());
		System.out.println("Result set: "+res.getResultSet().size());*/
		/*EDIT PROFILE TEST END*/
		
		
		/*REMOVE PROFILE TEST BEGIN*/
		/*String nickname= "T;lqUQ8O.L.P%tIH4ds$w7ieQNv2nNUa]LaNpKDvrG>cUqR6e3Umsak_5";
		String access_key= "Dhf$KqFf%u1Y?w#&cYnC.58Ok^RE86ay0C^TD9slIlD,].kt;P9-?o7XfQ9cc*@7I8%;vYXjx3Ie1zZMQ&K;sO*AF:h[-3[3X1FwcAE@ikZ;BCCmtdVa)&HExSaIDywQXJs7Dbppf52JM&2gY;d+EuL,ZqyC^OBK=Z2m@Y,B";		
		boolean res= service.removeProfileByNickname(nickname, access_key);
		System.out.println("Remove status: "+res);*/
		/*REMOVE PROFILE TEST END*/
	}
}
