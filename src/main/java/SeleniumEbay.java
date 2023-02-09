import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumEbay {
	
  public static void main(String args[])
  {
	WebDriver driver=new ChromeDriver();
  driver.get("https://www.ebay.com/sch/ebayadvsearch");
 
 // driver.findElement(By.xpath("//input[@name=\"_nkw\"][@id=\"_nkw\"]")).click();
 // driver.findElement(By.xpath("//input[@name=\"_nkw\"][@id=\"_nkw\"]")).clear();
  //driver.findElement(By.xpath("//input[@name=\"_nkw\"][@id=\"_nkw\"]")).sendKeys("Apple iphone");
 // driver.findElement(By.name("_sacat")).click();
  //driver.findElement(By.xpath("(//button)[6]")).click();
 //WebElement drop= driver.findElement(By.id("s0-1-17-4[0]-7[3]-_sacat"));
 //Select s=new Select(drop);
 //s.selectByIndex(2);
 // driver.findElement(By.linkText("search tips")).click();
 // Set<String>windows=driver.getWindowHandles();
  //List<String>windowlist=new ArrayList<>(windows);
	
	//driver.switchTo().window(windowlist.get(1));
	//driver.getTitle();
	
	//driver.findElement(By.linkText("Clear options")).click();
	
	//driver.switchTo().window(windowlist.get(0));
	//driver.switchTo().window(windowlist.get(1));
  
  WebElement depature=driver.findElement(By.xpath("//input[@placeholder='Depart']"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click(0);" ,depature);
	js.executeScript("window.scrollTo(250,1000)");
	
	
  }

}
