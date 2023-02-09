package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EbayFileReader {
	public static String pfilereader(String name)
	{
		FileInputStream fis=null;
		Properties prop=null;
		try
		{
			fis=new FileInputStream(new File("C:\\Users\\ctvla\\eclipse-workspace\\Ebayproject\\src\\main\\java\\resources\\Ebayconfig.properties"));
			prop=new Properties();
			prop.load(fis);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		//System.out.println(prop.getProperty(name));
		return prop.getProperty(name);
	}

}
