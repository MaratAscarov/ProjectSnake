package PackageSnake;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ConfigSnake {

	private Color myColor[] = {
			
			Color.white,		
			Color.lightGray,			
			Color.gray, 			
			Color.darkGray, 			
			Color.black, 			
			Color.red, 			
			Color.pink, 			
			Color.orange, 			
			Color.yellow, 			
			Color.green, 			
			Color.magenta, 			
			Color.cyan, 			
			Color.blue 			
			};

	private FileInputStream f;
	private ArrayList configList;
	private FileOutputStream fOutput;
	
	public ArrayList loadConfig()
	{
		 try {
			f = new FileInputStream("options.cfg");
			
			int b = 0;
			String buf = "";
			configList = new ArrayList();
			do
			{			
				try {
					b = f.read();
					if(b != -1)
					{
						if(b != 10 && b != 13)
							buf = buf + (char) b;
						if(b == 10)
						{	
							configList.add(buf);
							buf = "";
						}
					}	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			while(b != -1);
			configList.add(buf);
			try {
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return configList;
	}
	

	public String getField(String line)
	{
		String processedValue = "";
		processedValue = line.substring(0, line.indexOf("="));
		processedValue = processedValue.replace(" ", "");
		return processedValue;
	}
	
	public String getValue(String line)
	{
		String processedValue = "";
		processedValue = line.substring(line.indexOf("=") + 1);
		processedValue = processedValue.replace(" ", "");
		return processedValue;
	}
	
	public Color getColorValue(String line)
	{
		Color c = Color.black;
		String processedValue = "";
		processedValue = line.substring(line.indexOf("=") + 1);
		processedValue = processedValue.replace(" ", "");
		if(processedValue.equals("Color.white"))
			c = Color.white;		
		if(processedValue.equals("Color.lightGray"))
			c = Color.lightGray;			
		if(processedValue.equals("Color.gray"))
			c =	Color.gray; 			
		if(processedValue.equals("Color.darkGray"))
			c = Color.darkGray; 			
		if(processedValue.equals("Color.black"))
			c = Color.black; 			
		if(processedValue.equals("Color.red")) 
			c = Color.red; 			
		if(processedValue.equals("Color.pink")) 
			c = Color.pink; 			
		if(processedValue.equals("Color.orange")) 
			c = Color.orange;	
		if(processedValue.equals("Color.yellow")) 
			c = Color.yellow; 			
		if(processedValue.equals("Color.green")) 
			c = Color.green; 			
		if(processedValue.equals("Color.magenta")) 
			c = Color.magenta; 			
		if(processedValue.equals("Color.cyan")) 
			c = Color.cyan; 			
		if(processedValue.equals("Color.blue")) 
			c = Color.blue; 			
		return c;
	}
	
	public String getColorStringValue(Color c)
	{
		String sColor = "";
		
		if(c.getRGB() == Color.white.getRGB())
			sColor = "Color.white";		
		if(c.getRGB() == Color.lightGray.getRGB())
			sColor = "Color.lightGray";			
		if(c.getRGB() == Color.gray.getRGB())
			sColor = "Color.gray"; 			
		if(c.getRGB() == Color.darkGray.getRGB())
			sColor = "Color.darkGray"; 			
		if(c.getRGB() == Color.black.getRGB())
			sColor = "Color.black"; 			
		if(c.getRGB() == Color.red.getRGB()) 
			sColor = "Color.red"; 			
		if(c.getRGB() == Color.pink.getRGB()) 
			sColor = "Color.pink"; 			
		if(c.getRGB() == Color.orange.getRGB()) 
			sColor = "Color.orange";	
		if(c.getRGB() == Color.yellow.getRGB()) 
			sColor = "Color.yellow"; 			
		if(c.getRGB() == Color.green.getRGB()) 
			sColor = "Color.green"; 			
		if(c.getRGB() == Color.magenta.getRGB()) 
			sColor = "Color.magenta"; 			
		if(c.getRGB() == Color.cyan.getRGB()) 
			sColor = "Color.cyan"; 			
		if(c.getRGB() == Color.blue.getRGB()) 
			sColor = "Color.blue"; 			
		return sColor;
	}
	
	
	public void saveConfig(ArrayList aList)
	{
		String s = "";
		for(int i = 0; i < aList.size(); i++)
		{
			if(i != aList.size() - 1) s = s + aList.get(i) + "\r\n";
			if(i == aList.size() - 1) s = s + aList.get(i);
		}
		try {
			fOutput = new FileOutputStream("options.cfg");
			int b = 0;
			
			try {
				for(int i = 0; i < s.length(); i++)
					fOutput.write(s.charAt(i));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void outConfig()
	{
		System.out.println(configList);
	}
	
	
}
