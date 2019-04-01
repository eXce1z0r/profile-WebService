package org.pws.assets;

import java.util.Random;

public class Randomizer 
{
	private static Random randomizer= new Random();
	
	private static char[] validChars= new char[] {'#', '$', '%', '&', '(', ')', 
			'*', '+', ',', '-', '.', '0', '1', '2', '3', '4', '5', '6', '7', '8', 
			'9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 
			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
			'U', 'V', 'W', 'X', 'Y', 'Z', '[', ']', '^', 'a', 'b', 'c', 'd', 'e', 
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
			't', 'u', 'v', 'w', 'x', 'y', 'z', '_'};
	
	public static int getRandomValueInRange(int from, int to)
	{
		return randomizer.nextInt(to-from)+from;
	}
	
	public static double getRandomValueInRange(double from, double to)
	{
		return (randomizer.nextDouble()*(to - from))+from;
	}
	
	public static char getRandomValidChar()
	{
		return validChars[getRandomValueInRange(0, validChars.length-1)];
	}
	
	public static char getRandomValidCharForNickname()
	{
		return validChars[getRandomValueInRange(0, validChars.length-2)];
	}
}
