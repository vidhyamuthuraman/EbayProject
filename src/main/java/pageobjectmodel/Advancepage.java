package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.EbayFileReader;


public class Advancepage {
	
	WebDriver driver;

	public Advancepage(WebDriver driver)

	{
		this.driver=driver;
	  
	}
	public WebElement search()
	{
		WebElement search=driver.findElement(By.xpath(EbayFileReader.pfilereader("search")));
		return search;
	}
	
	public WebElement finalsearch()
	{
		WebElement finalsearch=driver.findElement(By.xpath(EbayFileReader.pfilereader("search1")));
		return finalsearch;
	}
	By Keyword=By.xpath(EbayFileReader.pfilereader("keyword"));
	public WebElement keyword()
	{
		WebElement keyword=driver.findElement(Keyword);
		return keyword;
	}
	
	public WebElement category()
	{
		WebElement drop= driver.findElement(By.id("s0-1-17-4[0]-7[3]-_sacat"));
		//Select s=new Select(drop);
		 //s.selectByIndex(7);
		 return drop;
	}
	
	//By Titledescription=By.xpath(EbayFileReader.pfilereader("titledescription"));
	public WebElement titledesc()
	{
		WebElement titledescription=driver.findElement(By.xpath(EbayFileReader.pfilereader("titledescription")));
		//WebElement titledescription=driver.findElement(Titledescription);
		return titledescription;
	}
	public WebElement completeditems()
	{
		WebElement compitems=driver.findElement(By.xpath(EbayFileReader.pfilereader("completeditems")));
		//WebElement titledescription=driver.findElement(Titledescription);
		return compitems;
	}
	public WebElement solditems()
	{
		WebElement sold=driver.findElement(By.xpath(EbayFileReader.pfilereader("solditems")));
		//WebElement titledescription=driver.findElement(Titledescription);
		return sold;
	}
	
	public WebElement minprice()
	{
		WebElement lowprice=driver.findElement(By.xpath(EbayFileReader.pfilereader("minprice")));
		//WebElement titledescription=driver.findElement(Titledescription);
		return lowprice;
	}
	public WebElement maxprice()
	{
		WebElement highprice=driver.findElement(By.xpath(EbayFileReader.pfilereader("maxprice")));
		//WebElement titledescription=driver.findElement(Titledescription);
		return highprice;
	}
	public WebElement usedcondition()
	{
		WebElement used=driver.findElement(By.xpath(EbayFileReader.pfilereader("usedcondition")));
		used.click();
		return used;
	}
	public WebElement newcondition()
	{
		WebElement newcondition=driver.findElement(By.xpath(EbayFileReader.pfilereader("newcondition")));
		return newcondition;
	}
	public WebElement miles()
	{
		WebElement miles=driver.findElement(By.xpath(EbayFileReader.pfilereader("miles")));
		return miles;
	}
	
	public WebElement zipcode()
	{
		WebElement zipcode=driver.findElement(By.xpath(EbayFileReader.pfilereader("zipcode")));
		return zipcode;
	}
	public WebElement seller()
	{
		WebElement seller=driver.findElement(By.xpath(EbayFileReader.pfilereader("seller")));
		return seller;
	}
	public WebElement sellertext()
	{
		WebElement sellertext=driver.findElement(By.xpath(EbayFileReader.pfilereader("sellertext")));
		return sellertext;
	}
	public WebElement freeshipping()
	{
		WebElement freeshipping=driver.findElement(By.xpath(EbayFileReader.pfilereader("freeshipping")));
	    return freeshipping;
	}
	public WebElement localpickup()
	{
		WebElement localpickup=driver.findElement(By.xpath(EbayFileReader.pfilereader("localoptions")));
	    return localpickup;
	}
	public WebElement searchtip_link()
	{
		WebElement searchtip=driver.findElement(By.linkText(EbayFileReader.pfilereader("searchtiplink")));
		return searchtip;
	}
	
	public WebElement clearoptions()
	{
		WebElement clear=driver.findElement(By.linkText(EbayFileReader.pfilereader("clearoptions")));
		return clear;
	}
	public WebElement buyingformat()
	{
		WebElement buyitnow=driver.findElement(By.xpath(EbayFileReader.pfilereader("buyitnow")));
		return buyitnow;
	}
	public WebElement viewresults()
	{
		WebElement viewresult=driver.findElement(By.name(EbayFileReader.pfilereader("viewresult")));
		return viewresult;
	}
	public WebElement itemsperpage()
	{
		WebElement itempage=driver.findElement(By.name(EbayFileReader.pfilereader("itemsperpage")));
		return itempage;
	}
	
	
		
}
