package baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.EbayFileReader;

public class BrowserEbay {

	static WebDriver driver;
	
	public static WebDriver getdriver()
	{
		driver=new ChromeDriver();
		driver.get(EbayFileReader.pfilereader("url"));
		return driver;
		
	}
	
}
