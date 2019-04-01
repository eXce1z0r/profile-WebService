package org.pws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Result") // name - responsible for setting name of main class at xml file.
public class DefaultResult implements ResultTemplate
{
	private boolean status= false;
	
	private String info= null;
	
	private Object[] resultSet= null;
	
	public DefaultResult() 
	{
		
	}

	public DefaultResult(boolean status, Object[] resultSet, String info) 
	{
		this.status = status;
		this.resultSet = resultSet;
		this.info = info;
	}

	@Override
	public boolean getStatus() 
	{
		return status;
	}
	
	@Override
	public void setStatus(boolean status)
	{
		this.status= status;
	}
	
	@Override
	public Object[] getResultSet() 
	{
		return resultSet;
	}
	
	@Override
	public void setResultSet(Object[] resultSet)
	{
		this.resultSet= resultSet;
	}

	@Override
	public String getInfo() 
	{
		return info;
	}
	
	@Override
	public void setInfo(String info)
	{
		this.info= info;
	}
}
