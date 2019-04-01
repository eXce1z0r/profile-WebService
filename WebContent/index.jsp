<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="width: 100%; height: 100%; min-height: 435px;">
<head>
	<meta charset="UTF-8">
	<link rel= "stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	
	<title>Profile Web Storage</title>
</head>
<body background="/ProfileWebService/resources/bg.jpg" style="width: 100%; height: 90%; background-size: 100% 100%; background-repeat: no-repeat;">
	<dir id="header">
		<nav class="navbar navbar-dark bg-dark">
	  		<a class="navbar-brand" href="#">
	    		<img src="/ProfileWebService/resources/logo.png" width="30" height="30" class="d-inline-block align-top" alt=""/>
	    		Profile Web Storage
	  		</a>
		</nav>
	</dir>
	<dir id="body" style="width: 97%; height: 65%;">
		<ul class="nav nav-tabs" id="myTab" role="tablist">
		  <li class="nav-item">
		    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Home</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="examples" aria-selected="false">Client usage examples</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="about" aria-selected="false">About</a>
		    
		  </li>
		</ul>
		
		<div class="tab-content" id="myTabContent" style="width: 100%; height: 90%;">
		  <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab" style="background: rgba(238,130,238, 0.5); border: 1px solid white; padding: 5px; width: 100%; height: 100%; overflow-y:scroll;">
		  	<h6>
		  		To download all client class and java files of this service use cmd command:
		  		<a class="btn btn-primary" href="https://docs.oracle.com/javase/6/docs/technotes/tools/share/wsimport.html" role="button">wsimport</a>.
		  	</h6>
		  	<h6>Example:</h6>
		  	<kbd><kbd>wsimport</kbd><kbd> </kbd><kbd>-keep</kbd><kbd> </kbd><kbd>-p</kbd><kbd> </kbd><kbd>&lt;package_name&gt;</kbd><kbd> </kbd><kbd>&lt;wsdl&gt;</kbd></kbd>
		  	<smpl>
		  	<h6></h6>
		  </div>
		  <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab" style="background: rgba(135,206,235, 0.5); border: 1px solid white; padding: 5px; width: 100%; height: 100%; overflow-y:scroll;">
		  	<h6>Profile add part example:</h6>
				<code>
				<pre style="background: rgba(255,255,255, 0.9); border: 5px groove rgba(135,206,255, 1);">
				TestProfilesWebStorageService service= new TestProfilesWebStorageService();
				TestProfilesWebStorage servicePort= service.getTestProfilesWebStoragePort();
				
				ProfileImpl profile= new ProfileImpl();
				ProfileInfo profileInfo= new ProfileInfo();
				List&lt;Entry&gt; profileInfoEntry= profileInfo.getEntry();
						
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
							
				List&lt;Object&gt; resSet= res.getResultSet();
				if(resSet.size() > 0)
				{
					System.out.println("Result: ");
					for(int i= 0; i< resSet.size(); i++)
					{
						System.out.println("\t"+resSet.get(i));
					}
				}
				</pre>
				</code>
			<h6>Profile get part example:</h6>
				<code>
				<pre style="background: rgba(255,255,255, 0.9); border: 5px groove rgba(135,206,255, 1);">
				TestProfilesWebStorageService service= new TestProfilesWebStorageService();
				TestProfilesWebStorage servicePort= service.getTestProfilesWebStoragePort();
			
				String nickname= ""; // autogenerated nickname of user which you need to get
				String accessKey= ""; // autogenerated accessKey of user which you need to get
			
				DefaultResult res= servicePort.getProfileByNickname(nickname, accessKey);
				System.out.println("----- Get request result -----");
				System.out.println("Status: "+res.isStatus());
				System.out.println("Info: "+res.getInfo());
							
				List&lt;Object&gt; resultSet= res.getResultSet();
				if(resultSet != null && resultSet.size() > 0)
				{
					System.out.println("Result set: ");
					ProfileImpl profile= (ProfileImpl)resultSet.get(0);			
					ProfileInfo profileInfo= profile.getProfileInfo();
					Iterator&lt;Entry&gt; profileInfoEntrySet= profileInfo.getEntry().iterator();
					while(profileInfoEntrySet.hasNext())
					{
						Entry profileEntry= profileInfoEntrySet.next();
												
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
										
									resFlag= ImageIO.write((BufferedImage)img, "png", new File("image_download_path\\img_name.png"));
										
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
					}
				}
				</pre>
				</code>
			<h6>Profile edit part example:</h6>
				<code>
				<pre style="background: rgba(255,255,255, 0.9); border: 5px groove rgba(135,206,255, 1);">
				TestProfilesWebStorageService service= new TestProfilesWebStorageService();
				TestProfilesWebStorage servicePort= service.getTestProfilesWebStoragePort();
			
				String nickname= ""; // autogenerated nickname of user which you need to edit
				String accessKey= ""; // autogenerated accessKey of user which you need to edit
			
				ProfileImpl profile= new ProfileImpl();		
				ProfileInfo profileInfo= new ProfileInfo();
					
				List&lt;Entry&gt; profileInfoEntry= profileInfo.getEntry();
					
				Entry profileInfoParam= new Entry();
				profileInfoParam.setKey("username"); // name of field which need to edit
				profileInfoParam.setValue("testUsername"); // value which need to enter
				profileInfoEntry.add(profileInfoParam);
					
				profileInfoParam= new Entry();
				profileInfoParam.setKey("surname"); // name of field which need to edit
				profileInfoParam.setValue("testSurname"); // value which need to enter
				profileInfoEntry.add(profileInfoParam);
			
				/*...more fields if need...*/
					
				profile.setProfileInfo(profileInfo);
					
				DefaultResult res= servicePort.editProfileByNickname(nickname, accessKey, profile);
					
				System.out.println("----- Edit request result -----");
				System.out.println("Status: "+res.isStatus());
				System.out.println("Info: "+res.getInfo());
							
				List&lt;Object&gt; resultSet= res.getResultSet();
				if(resultSet != null && resultSet.size() > 0)
				{
					System.out.println("Result set: ");
					ProfileImpl resProfile= (ProfileImpl)resultSet.get(0);			
					ProfileInfo resProfileInfo= resProfile.getProfileInfo();
					Iterator&lt;Entry&gt; profileInfoEntrySet= resProfileInfo.getEntry().iterator();
					while(profileInfoEntrySet.hasNext())
					{
						Entry profileEntry= profileInfoEntrySet.next();
							
						System.out.println(profileEntry.getKey()+": "+profileEntry.getValue());
					}
				}
				</pre>
				</code>
			<h6>Profile remove part example:</h6>
				<code>
				<pre style="background: rgba(255,255,255, 0.9); border: 5px groove rgba(135,206,255, 1);">
				TestProfilesWebStorageService service= new TestProfilesWebStorageService();
				TestProfilesWebStorage servicePort= service.getTestProfilesWebStoragePort();
			
				String nickname= ""; // autogenerated nickname of user which you need to remove
				String accessKey= ""; // autogenerated accessKey of user which you need to remove
			
				System.out.println("----- Remove request result -----");
				boolean res= servicePort.removeProfileByNickname(nickname, accessKey);
				System.out.println("Remove result: "+res);
				</pre>
				</code>
			</pre>
		  </div>
		  <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab" style="background: rgba(255,255,51, 0.5); border: 1px solid white; padding: 5px; width: 100%; height: 100%; overflow-y:scroll;">
				Web service give user oportunity of adding users to service database and also give oportunities to get/edit/remove profiles 
			by secret nickname and key which generated randomly and return as result of adding new user. Also each profile
			has 3 access controll variables (global_access_flag, edit_flag, remove_flag) which define interaction of this web service and
			profile, by default profiles which created throught this web service already have settet as available.
				Was created for java web service learning purposes.
		  </div>
		</div>
	</dir>
	<div class="footer" style="position: fixed; left: 0; bottom: 0; width: 100%; background-color: rgba(0,0,0,0.5); color: white; text-align: center;">
  		<div class="footer-copyright text-center py-3">© 2019 Copyright:
		  	<button type="button" class="btn btn-outline-primary">e</button>
			<button type="button" class="btn btn-outline-secondary">X</button>
			<button type="button" class="btn btn-outline-success">c</button>
			<button type="button" class="btn btn-outline-danger">e</button>
			<button type="button" class="btn btn-outline-warning">1</button>
			<button type="button" class="btn btn-outline-info">z</button>
			<button type="button" class="btn btn-outline-light">0</button>
			<button type="button" class="btn btn-outline-primary">r</button> <!-- btn-outline-dark too dark -->
	</div>
</body>
</html>