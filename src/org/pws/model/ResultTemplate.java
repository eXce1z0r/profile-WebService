package org.pws.model;

public interface ResultTemplate
{
	public boolean getStatus();
	
	public void setStatus(boolean status);
	
	public Object[] getResultSet();
	
	public void setResultSet(Object[] resultSet);
	
	public String getInfo();
	
	public void setInfo(String info);
}
