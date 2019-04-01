package org.pws.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import org.postgresql.util.PSQLException;
import org.pws.model.DefaultResult;
import org.pws.model.ProfileTemplate;
import org.pws.model.ProfileImpl;
import org.pws.model.ResultTemplate;

public class PostgreSQLDatabaseService implements DatabaseServiceTemplate
{
	private Connection conn= null;
	
	private String ip= "localhost";
	private int port= 5432;
	private String dbName= "profile_storage";
	private String dbUserName= "linux_admin";
	private String dbUserPassword= "linux_admin";
	
	public PostgreSQLDatabaseService()
	{
		connect();
		
		//get last access req id
	}
	
	public PostgreSQLDatabaseService(String ip, int port, String dbName, String dbUserName, String dbUserPassword)
	{
		this.ip= ip;
		this.port= port;
		this.dbName= dbName;
		this.dbUserName= dbUserName;
		this.dbUserPassword= dbUserPassword;
		
		connect();
		
		//get last access req id
	}
	
	@Override
	public boolean connect() 
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		StringBuilder connUrl= new StringBuilder().
				append("jdbc:postgresql://").
				append(ip).append(":").
				append(port).append("/").
				append(dbName);
		
		try 
		{
			conn= DriverManager.getConnection(connUrl.toString(), dbUserName, dbUserPassword);
			return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public DefaultResult addProfile(ProfileTemplate profile)
	{
		String accessTableSqlReq= "INSERT INTO public.\"profiles_access_info\" (nickname, access_key, global_access_flag, edit_flag, remove_flag) VALUES (?, '"+profile.getAccessKey()+"', 1, true, true);"; // here you can set default access variables 	
		PreparedStatement accessTableReqStmt= null;		
		try 
		{
			accessTableReqStmt= conn.prepareStatement(accessTableSqlReq, Statement.RETURN_GENERATED_KEYS);
			accessTableReqStmt.setNull(1, Types.NULL);
			accessTableReqStmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		long accessTableID= -1;
		try 
		{
			ResultSet genKeySet= accessTableReqStmt.getGeneratedKeys();
			if(genKeySet.next())
			{
				accessTableID= genKeySet.getLong("id");
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		Map<String, Object> profileInfo= profile.getProfileInfo();		
		if(accessTableID != -1 && profileInfo != null)
		{		
			Iterator<Entry<String, Object>> profileInfoIterator= profileInfo.entrySet().iterator();
			//String profileTableSqlReq= "INSERT INTO public.\"profiles_table\" (access_info, username, surname, patronymic, email, photo, age) VALUES ("+accessTableID+", '"+profileInfo[0]+"', '"+profileInfo[1]+"', '"+profileInfo[2]+"', '"+profileInfo[3]+"', '"+profileInfo[4]+"', "+profileInfo[5]+");";
			String profileTableSqlReq= null;
			StringBuilder paramNames= null;
			StringBuilder paramValues= null;
			
			String[] keysPosArray= new String[profileInfo.size()]; // used for recording positions of keys at insert request to set right values for them
			int keysPosCounter= 0;
			
			boolean firstTimeFlag= true;
			while(profileInfoIterator.hasNext())
			{
				Entry<String, Object> param= profileInfoIterator.next();
				
				keysPosArray[keysPosCounter++] = param.getKey();
				
				if(firstTimeFlag)
				{
					paramNames= new StringBuilder("INSERT INTO public.\"profiles_table\" (").append(param.getKey());
					
					/*if(param.getValue() instanceof String || param.getValue() instanceof Character)
					{
						paramValues= new StringBuilder(" VALUES ('").append(param.getValue()).append("'");
					}
					else
					{
						paramValues= new StringBuilder(" VALUES (").append(param.getValue());
					}*/
					
					paramValues= new StringBuilder(" VALUES (?");
										
					firstTimeFlag= false;
				}
				else
				{
					paramNames.append(", ").append(param.getKey());
					
					/*if(param.getValue() instanceof String || param.getValue() instanceof Character)
					{
						paramValues.append(", '").append(param.getValue()).append("'");
					}
					else
					{
						paramValues.append(", ").append(param.getValue());
					}*/
					paramValues.append(", ?");
				}				
			}
			
			if(firstTimeFlag) // check if 
			{
				paramNames= new StringBuilder("INSERT INTO public.\"profiles_table\" (access_info)");
				paramValues= new StringBuilder(" VALUES (").append(accessTableID).append(");");
			}
			else
			{			
				paramNames.append(", access_info)");
				paramValues.append(", ").append(accessTableID).append(");");
			}
			profileTableSqlReq= paramNames.toString()+paramValues.toString();
			
			PreparedStatement profileTableID= null;
			try 
			{
				profileTableID= conn.prepareStatement(profileTableSqlReq, Statement.RETURN_GENERATED_KEYS);
				
				profileInfoIterator= profileInfo.entrySet().iterator();				
				for(int i= 0; i< keysPosArray.length; i++)
				{
					Object profileInfoFieldValue= profileInfo.get(keysPosArray[i]);
					
					int psIndex= i+1;
					if(profileInfoFieldValue instanceof String)
					{
						profileTableID.setString(psIndex, (String)profileInfoFieldValue);
					}
					else if(profileInfoFieldValue instanceof Character)
					{
						profileTableID.setString(psIndex, String.valueOf(profileInfoFieldValue));
					}
					else if(profileInfoFieldValue instanceof Double)
					{
						profileTableID.setDouble(psIndex, (Double)profileInfoFieldValue);
					}
					else if(profileInfoFieldValue instanceof Float)
					{
						profileTableID.setFloat(psIndex, (Float)profileInfoFieldValue);
					}
					else if(profileInfoFieldValue instanceof Long)
					{
						profileTableID.setLong(psIndex, (Long)profileInfoFieldValue);
					}
					else if(profileInfoFieldValue instanceof Integer)
					{
						profileTableID.setInt(psIndex, (Integer)profileInfoFieldValue);
					}
					else if(profileInfoFieldValue instanceof Short)
					{
						profileTableID.setShort(psIndex, (Short)profileInfoFieldValue);
					}
					else if(profileInfoFieldValue instanceof Byte)
					{
						profileTableID.setByte(psIndex, (Byte)profileInfoFieldValue);
					}
					else if(profileInfoFieldValue instanceof Boolean)
					{
						profileTableID.setBoolean(psIndex, (Boolean)profileInfoFieldValue);
					}
					else if(profileInfoFieldValue instanceof InputStream)
					{
						profileTableID.setBinaryStream(psIndex, (InputStream)profileInfoFieldValue);
					}
					else
					{
						profileTableID.setNull(psIndex, java.sql.Types.NULL);
					}
				}
				
				profileTableID.executeUpdate();
				
				ResultSet genKeySet= profileTableID.getGeneratedKeys();
				long requestId= -1; 
				if(genKeySet.next())
				{
					requestId= genKeySet.getLong("id");
				}

				profile.generateNickname(requestId); // the part in which unique identifiers are selected
				
				accessTableSqlReq= "UPDATE public.\"profiles_access_info\" SET nickname = ? WHERE id = ?";
				accessTableReqStmt= conn.prepareStatement(accessTableSqlReq);
				accessTableReqStmt.setString(1, profile.getNickname());
				accessTableReqStmt.setLong(2, accessTableID);
				int rowsAdded= accessTableReqStmt.executeUpdate();
				
				return new DefaultResult(true, new Object[] {profile.getNickname(), profile.getAccessKey()}, "new user with id \""+requestId+"\" has been successfully added!!!");
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
			
		return new DefaultResult(false, null, "Sorry, something went wrong.");
	}

	@Override
	public DefaultResult getProfileByNickname(String nickname, String accessKey) 
	{		
		String sqlReq= "SELECT username, surname, patronymic, email, photo, age " + 
				"FROM public.\"profiles_table\" " + 
				"WHERE access_info = (SELECT id " + 
				"						FROM public.\"profiles_access_info\" WHERE nickname='"+nickname+"' AND " + 
				"						access_key='"+accessKey+"' AND " + 
				"						global_access_flag=1 LIMIT 1);";
		
		ResultSet res= null;
		
		try 
		{
			PreparedStatement stmt= conn.prepareStatement(sqlReq);
			res= stmt.executeQuery();
			if(res.next())
			{				
				Map<String, Object> params= new HashMap<>();
				
				int paramIndex= 1;
				boolean loopExecFlag= true;
				while(loopExecFlag)
				{		
					try
					{
						String paramClass= res.getMetaData().getColumnClassName(paramIndex);
						String paramName= res.getMetaData().getColumnName(paramIndex);
						
						if(paramClass.equals(String.class.getName()) || paramClass.equals(Character.class.getName()))
						{
							params.put(paramName, res.getString(paramIndex));
						}
						else if(paramClass.equals(Double.class.getName()))
						{
							params.put(paramName, res.getDouble(paramIndex));
						}
						else if(paramClass.equals(Float.class.getName()))
						{
							params.put(paramName, res.getFloat(paramIndex));
						}
						else if(paramClass.equals(Long.class.getName()))
						{
							params.put(paramName, res.getLong(paramIndex));
						}
						else if(paramClass.equals(Integer.class.getName()))
						{
							params.put(paramName, res.getInt(paramIndex));
						}
						else if(paramClass.equals(Short.class.getName()))
						{
							params.put(paramName, res.getShort(paramIndex));
						}
						else if(paramClass.equals(Byte.class.getName()))
						{
							params.put(paramName, res.getByte(paramIndex));
						}
						else if(paramClass.equals(Boolean.class.getName()))
						{
							params.put(paramName, res.getBoolean(paramIndex));
						}
						else if(paramClass.equals("[B"))
						{
							InputStream photoStream= res.getBinaryStream(paramIndex);
							if(photoStream != null)
							{
								try 
								{
									BufferedImage img= ImageIO.read(photoStream);
									
									ByteArrayOutputStream bAOS= new ByteArrayOutputStream();								
									ImageIO.write(img, "png", bAOS);
									bAOS.flush();
									
									byte[] imgBA= bAOS.toByteArray();
									
									params.put(paramName, imgBA);
									
									bAOS.close();
								} 
								catch (IOException e) 
								{
									e.printStackTrace();
								}
								
								try 
								{
									photoStream.close();
								} 
								catch (IOException e) 
								{
									e.printStackTrace();
								}
							}
							else
							{
								params.put(paramName, null);
							}
						}
						else
						{
							// In case if someone add unregistered type
							params.put(paramName, res.getObject(paramIndex));
						}
					}
					catch(PSQLException e)
					{
						paramIndex--;
						loopExecFlag= false;
					}
					
					paramIndex++;
				}

				return new DefaultResult(true, new Object[] {new ProfileImpl(params)}, "Ok");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return new DefaultResult(false, null, "No such profile was found.");
	}

	@Override
	public DefaultResult editProfileByNickname(String nickname, String accessKey, ProfileTemplate profile) 
	{
		Object[] profileByCredsRes= getProfileByNickname(nickname, accessKey).getResultSet();
		if(profileByCredsRes != null)
		{
			ProfileTemplate oldProfileVersion= (ProfileTemplate)profileByCredsRes[0];
			if(oldProfileVersion != null)
			{
				StringBuilder sqlReq= new StringBuilder("UPDATE public.\"profiles_table\" SET ");
				
				List<Object> updatedFieldsValues= new ArrayList<>();
				//int updatedFieldsCounter= 0;
				
				Iterator<Entry<String, Object>> updatedFields= profile.getProfileInfo().entrySet().iterator();			
				boolean hasPrevFlag= false;
				while(updatedFields.hasNext())
				{
					Entry<String, Object> newField= updatedFields.next();
					if(newField.getKey() != "access_info" && oldProfileVersion.getProfileInfo().containsKey(newField.getKey()))
					{
						//fieldsToUpdate.put(newField.getKey(), newField.getValue());
						
						//sqlReq.append(newField.getKey()).append(" = ");
						
						/*if(newField.getValue() instanceof String || newField.getValue() instanceof Character)
						{
							sqlReq.append("'").append(newField.getValue()).append("'");
						}
						else
						{
							sqlReq.append(newField.getValue());
						}*/
						
						/*sqlReq.append("?");
						
						if(updatedFields.hasNext())
						{
							sqlReq.append(", ");
						}*/
						
						if((oldProfileVersion.getProfileInfo().get(newField.getKey()) instanceof String && newField.getValue() instanceof String && !((String)oldProfileVersion.getProfileInfo().get(newField.getKey())).equals((String)newField.getValue().toString())) 
								|| (!(oldProfileVersion.getProfileInfo().get(newField.getKey()) instanceof String) && !(newField.getValue() instanceof String) && oldProfileVersion.getProfileInfo().get(newField.getKey()) != newField.getValue()))
						{
							//updatedFieldsCounter++;
							updatedFieldsValues.add(newField.getValue());
							if(/*updatedFields.hasNext()*/hasPrevFlag)
							{
								sqlReq.append(", ");
							}
							
							sqlReq.append(newField.getKey()).append(" = ");
							
							sqlReq.append("?");
							
							hasPrevFlag= true;
						}
					}
				}
				
				sqlReq.append(" WHERE access_info = (SELECT id " + 
						"						FROM public.\"profiles_access_info\" WHERE nickname='"+nickname+"' AND " + 
						"						access_key='"+accessKey+"' AND " + 
						"						edit_flag = true LIMIT 1);");
				
				try 
				{
					PreparedStatement ps= conn.prepareStatement(sqlReq.toString());
					
					for(int i= 0; i< updatedFieldsValues.size(); i++)
					{
						Object newFieldValue= updatedFieldsValues.get(i);
						int psIndex= i+1;
						if(newFieldValue instanceof String)
						{
							ps.setString(psIndex, (String)newFieldValue);
						}
						else if(newFieldValue instanceof Character)
						{
							ps.setString(psIndex, String.valueOf(newFieldValue));
						}
						else if(newFieldValue instanceof Double)
						{
							ps.setDouble(psIndex, (Double)newFieldValue);
						}
						else if(newFieldValue instanceof Float)
						{
							ps.setFloat(psIndex, (Float)newFieldValue);
						}
						else if(newFieldValue instanceof Long)
						{
							ps.setLong(psIndex, (Long)newFieldValue);
						}
						else if(newFieldValue instanceof Integer)
						{
							ps.setInt(psIndex, (Integer)newFieldValue);
						}
						else if(newFieldValue instanceof Short)
						{
							ps.setShort(psIndex, (Short)newFieldValue);
						}
						else if(newFieldValue instanceof Byte)
						{
							ps.setByte(psIndex, (Byte)newFieldValue);
						}
						else if(newFieldValue instanceof Boolean)
						{
							ps.setBoolean(psIndex, (Boolean)newFieldValue);
						}
						else if(newFieldValue instanceof InputStream)
						{
							ps.setBinaryStream(psIndex, (InputStream)newFieldValue);
						}
						else
						{
							ps.setNull(psIndex, java.sql.Types.NULL);
						}
						
					}
					
					if(updatedFieldsValues.size() > 0)
					{
						ps.executeUpdate();
					}
					
					return new DefaultResult(true, null, updatedFieldsValues.size()+" profile fields have been changed.");
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	
						/*"WHERE access_info = (SELECT id " + 
						"						FROM public.profiles_access_info WHERE nickname='"+nickname+"' AND " + 
						"						access_key='"+accessKey+"' AND " + 
						"						global_access_flag=1 LIMIT 1);";*/
				
			}
		}
		return new DefaultResult(false, null, "Sorry, something went wrong.");
	}
	
	@Deprecated
	public boolean editProfilePermissions(String nickname, String accessKey, Map<String, Object> permissions) // just for test, this method should be called by the user from its page.
	{
		StringBuilder sqlReq= new StringBuilder("UPDATE public.\"profiles_access_info\" SET ");
		
		Iterator<Entry<String, Object>> permissionIterator= permissions.entrySet().iterator();
		while(permissionIterator.hasNext())
		{
			Entry<String, Object> permission= permissionIterator.next();
			if(permission.getValue() instanceof String || permission.getValue() instanceof Character)
			{
				sqlReq.append(permission.getKey()).append(" = '").append(permission.getValue()).append("'");
			}
			else
			{
				sqlReq.append(permission.getKey()).append(" = ").append(permission.getValue());
			}
			
			if(permissionIterator.hasNext())
			{
				sqlReq.append(", ");
			}
		}
		sqlReq.append(" WHERE nickname = '").append(nickname).append("' AND access_key = '").append(accessKey).append("';");
		
		try 
		{
			conn.prepareStatement(sqlReq.toString()).executeUpdate();
			return true;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean removeProfileByNickname(String nickname, String accessKey) 
	{
		String sqlReq= "SELECT id FROM public.\"profiles_access_info\" " +
				"						WHERE nickname='"+nickname+"' AND " + 
				"						access_key='"+accessKey+"' AND " +
				"						remove_flag = true LIMIT 1";
		
		try 
		{
			ResultSet profileAccessIdRS= conn.prepareStatement(sqlReq).executeQuery();
			long profileAccessId= -1;
			
			while(profileAccessIdRS.next())
			{
				profileAccessId= profileAccessIdRS.getLong("id");
			}
				
			if(profileAccessId > -1)
			{
				try 
				{
					sqlReq= "DELETE FROM public.\"profiles_table\" " + 
							"WHERE access_info = "+profileAccessId+";";
					conn.prepareStatement(sqlReq).executeUpdate();
					
					sqlReq= "DELETE FROM public.\"profiles_access_info\" " +
							"WHERE id = "+profileAccessId+";";
					conn.prepareStatement(sqlReq).executeUpdate();
					
					return true;
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} 
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}
}
