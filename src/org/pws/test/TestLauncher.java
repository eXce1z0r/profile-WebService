package org.pws.test;

import javax.xml.ws.Endpoint;

import org.pws.service.ProfileWebStorage;

public class TestLauncher 
{
	public static void main(String[] args)
	{
		Endpoint.publish("http://localhost:1234/profilesebstorageservice", new ProfileWebStorage());
	}
}
