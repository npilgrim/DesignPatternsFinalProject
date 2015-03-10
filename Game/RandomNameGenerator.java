import java.io.*;
import java.util.*;


public class RandomNameGenerator {

	private static RandomNameGenerator generator = null;
	
	private Random rand;
	
	private RandomNameGenerator()
	{
		rand = new Random();
	}
	
	public static RandomNameGenerator getGenerator()
	{
		if(generator == null)
			generator = new RandomNameGenerator();
		
		return generator;
	}
	
	/*
	 * Credit to fantasynamegenerators.com for the list of names/words(stored in names1-3, names2-3, and names 3-3)
	 *  	and the associated code from their Monster Name Generator
	 */
	
	public String randomName()
	{
		String name = "";
		Scanner file = null;
		int lines = 0;
		
		file = openFile("names1-3.txt");
		lines = countLines(file);
		file.close();
		file = openFile("names1-3.txt");
		
		name = name + getNamePart(file, rand.nextInt(lines));
		
		file = openFile("names2-3.txt");
		lines = countLines(file);
		file.close();
		file = openFile("names2-3.txt");
		
		name = name + " the " + getNamePart(file, rand.nextInt(lines));
		
		file = openFile("names3-3.txt");
		lines = countLines(file);
		file.close();
		file = openFile("names3-3.txt");
		
		name = name + getNamePart(file, rand.nextInt(lines));
		
		file.close();
		
		return name;
	}
	
	private Scanner openFile(String file)
	{
		Scanner result = null;
		try
		{	
			result = new Scanner(new File(file));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	private int countLines(Scanner s)
	{
		int count = 0;
		
		while(s.hasNextLine())
		{
			count++;
			s.nextLine();
		}
		
		return count;
	}
	
	private String getNamePart(Scanner file, int lineNum)
	{
		String r = "";
		
		for(int i = 0; i < lineNum-1; i++)
		{
			file.nextLine();
		}
		r = file.nextLine();
		
		return r;
	}
}
