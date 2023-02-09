package testcases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseclass.BrowserEbay;
import junit.framework.Assert;
import pageobjectmodel.Advancepage;

import utilities.EbayFileReader;


public class EbayTest {
	
	ExtentSparkReporter spark1=new ExtentSparkReporter(new File("testreport//spark1.html"));
	ExtentReports extent;
	ExtentTest test;
  
	 WebDriver driver;
	 @BeforeTest
	 public void getresult()
	 {  extent=new ExtentReports();
		extent.attachReporter(spark1);
		spark1.config().setDocumentTitle("Automation");
		spark1.config().setTheme(Theme.DARK);
		spark1.config().setReportName("Demo Report");
		//driver=BrowserEbay.getdriver();
	}
	
	@BeforeMethod(alwaysRun=true)
		
	public void setup()
	{
		
		driver=BrowserEbay.getdriver();
		driver.manage().window().maximize();
	}
	
/***********************************************************************************	
 *******************Test case to check search button if no data is given************
 ***********************************************************************************/	
	@Test(priority=0)
	public void testcase1() throws InterruptedException 
	{
		
		Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		a.search().submit();
		test=extent.createTest("testcase1","Able to search without entering values");
		
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://www.ebay.com/n/all-categories");
	    //AssertJUnit.assertTrue(true);
	    
		
  }
 /*****************************************************************************
	        Test case to search using keyword "Apple iphone"
  ******************************************************************************/ 
	 
	 
	@Test(priority=1)
	public void testcase2() throws InterruptedException
	{    
		
		Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		a.keyword().click();
		a.keyword().sendKeys("Apple iphone");
		a.search().submit();
		//driver.findElement(By.xpath(EbayFileReader.pfilereader("search"))).click();
		test=extent.createTest("testcase2","Able to search particular keyword example Apple iphone");
	     AssertJUnit.assertTrue(true);
	     //driver.navigate().back();
	}
	
/**********************************************************************************
	//Test case to search iphone from cell phone category
  ******************************************************************************/ 
	  
	 
	
	@Test(priority=2)
	public void testcase3() throws InterruptedException
	{
		Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		a.keyword().sendKeys("iphone");
	   WebElement drop1=a.category();
	   Select choice=new Select(drop1);
	   choice.selectByIndex(7);
	   a.search().submit();
	   test=extent.createTest("testcase3","Search iphone in cell phone category");
	    AssertJUnit.assertTrue(true);
		
	}
	
	/**********************************************************************************
	           Test case to search iphone from clothing category
	/**********************************************************************************/
	
	
	@Test(priority=3)
	public void testcase4() throws InterruptedException
	{
		Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		a.keyword().sendKeys("iphone");
	   WebElement drop1=a.category();
	   Select choice=new Select(drop1);
	   choice.selectByIndex(8);
	   a.search().submit();
		test=extent.createTest("testcase 4","Search iphone in clothing");
	    AssertJUnit.assertTrue(true);
		
	}
	
	/**********************************************************************************		
	           Test case to select all multiplechoices(Title,completed and sold)
	**********************************************************************************/
	@Test(priority=4)
	public void testcase5() throws InterruptedException
	{   Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		a.titledesc().click();
		a.solditems().click();
		a.completeditems().click();
		test=extent.createTest("testcase5","Able to select Title description,Sold items and Completed items");
		   AssertJUnit.assertEquals(true,a.titledesc().isSelected());
		   AssertJUnit.assertEquals(true,a.completeditems().isSelected());
		   AssertJUnit.assertEquals(true,a.solditems().isSelected());
	       
		//AssertJUnit.assertTrue(true);
	   // driver.navigate().back();
	}
	
	
	/**********************************************************************************	
	         Test case to select 1 choice Title description based on condition
	**********************************************************************************/
	@Test(priority=5)
	public void testcase6() throws InterruptedException
	{   Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		a.titledesc().click();
		if(a.titledesc().isSelected()&&a.solditems().isSelected())
		{
			a.completeditems().click();
			
		}
		else
		{
		 a.solditems().click();	
		}
	
        test=extent.createTest("testcase6","Able to select choices based on condition ");
        AssertJUnit.assertEquals(true,a.solditems().isSelected());
        //AssertJUnit.assertTrue(true);
	}
	
	/**********************************************************************************
	           Test case to set min and max value to zero and search items
	/**********************************************************************************/
	@Test(priority=6)
	public void testcase7() throws InterruptedException
	{
		Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		a.keyword().sendKeys("toys");
		a.minprice().sendKeys("0");
		a.maxprice().sendKeys("0");
		a.finalsearch().click();
		test=extent.createTest("testcase7","No match found if min and max value as zero");
	    
		AssertJUnit.assertEquals(driver.getCurrentUrl(),"https://www.ebay.com/sch/i.html?_nkw=toys&_udlo=0&_udhi=0");
		//AssertJUnit.assertTrue(true);
	}
	
	/**********************************************************************************	
	              //Test case to set min  to $5 and max value to $50
	/**********************************************************************************/
	
	@Test(priority=7)
	public void testcase8() throws InterruptedException
	{
		Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		a.keyword().sendKeys("toys");
		a.minprice().sendKeys("$5");
		a.maxprice().sendKeys("$50");
		a.finalsearch().click();
		test=extent.createTest("testcase8","Display toys between $5 and $50");
	    AssertJUnit.assertTrue(true);
	}

	/**********************************************************************************
		     Test case to set decimal value min  to $5.590 and max value to $50.527
	/**********************************************************************************/
	@Test(priority=8)
	public void testcase9() throws InterruptedException
	{
		Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		a.keyword().sendKeys("toys");
		a.minprice().sendKeys("$5.590");
		a.maxprice().sendKeys("$50.527");
		a.finalsearch().click();
		test=extent.createTest("testcase9","Display toys between  decimal values $5.590 and $50.527");
	    AssertJUnit.assertTrue(true);
	}
	
	/**********************************************************************************
	           //Test case to set string values(min) in min and max 
	**********************************************************************************/
	@Test(priority=9)
	public void testcase10() throws InterruptedException
	{
		Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		a.keyword().sendKeys("toys");
		a.minprice().sendKeys("min");
		a.maxprice().sendKeys("$50");
		a.finalsearch().click();
		test=extent.createTest("testcase10","Display toys even when string value is given for price");
	    AssertJUnit.assertTrue(true);
	}
	
	/**********************************************************************************	
		              Test case to select new item in radio button
	/**********************************************************************************/
	@Test(priority=10)
	public void testcase11() throws InterruptedException
	{
		Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		if(a.usedcondition().isEnabled())
		{
			a.newcondition().click();
		}
		
		else
			{
			a.usedcondition().click();}
		    test=extent.createTest("testcase11","Select condition new items in radio button");
	   		AssertJUnit.assertEquals(true,a.usedcondition().isSelected());
		    AssertJUnit.assertEquals(true,a.newcondition().isSelected());
		   
	       
		// AssertJUnit.assertTrue(true);	
		
	}
	
	/**********************************************************************************	
	            Test case to search within 1000 miles with zipcode 75072
	**********************************************************************************/
	@Test(priority=11)
	
	public void test12() throws InterruptedException
	{
		Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		WebElement miles1=a.miles();
		Select milechoice=new Select(miles1);
		milechoice.selectByVisibleText("1000");
		a.zipcode().sendKeys("75072");
		//driver.findElement(By.xpath("//input[@name='_stpos']")).sendKeys("75072");
		a.finalsearch().click();
		
		test=extent.createTest("testcase12","Search between 1000miles with zipcode 75072");
	    AssertJUnit.assertTrue(true);	
		
	}
	
	/**********************************************************************************	
	    Test case to search within 1000 miles with  string value in zipcode "Texas"
	 **********************************************************************************/
	@Test(priority=12)
	
	public void test13() throws InterruptedException
	{
		Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		WebElement miles1=a.miles();
		Select milechoice=new Select(miles1);
		milechoice.selectByVisibleText("500");
		
		//driver.findElement(By.xpath("//input[@name='_stpos']")).sendKeys("Texas");
		a.zipcode().sendKeys("Texas");
		a.finalsearch().click();
		
		test=extent.createTest("testcase13","Search between 500miles with zipcode value as string(Texas)");
	    AssertJUnit.assertTrue(true);	
		
	}
	/**********************************************************************************
	          Test case to search phone from specific seller including samsung 	
	**********************************************************************************/
@Test(priority=13)
	
	public void test14() throws InterruptedException
	{
		Thread.sleep(1000);
		Advancepage a=new Advancepage(driver);
		a.keyword().sendKeys("phone");
		WebElement seller1=a.seller();
		Select sellerchoice=new Select(seller1);
		sellerchoice.selectByVisibleText("Include");
		//driver.findElement(By.xpath("//input[@name=\"_sasl\"]")).sendKeys("seller,Samsung");
		a.sellertext().sendKeys("seller,Samsung");
		a.finalsearch().click();
		test=extent.createTest("testcase14","seller choice using words SELLER AND SAMSUNG");
	    AssertJUnit.assertTrue(true);	
	    Thread.sleep(1000);
	
	}

/**********************************************************************************
            Test case to select both Free shipping and Local pickups options
 **********************************************************************************/
@Test(priority=14)

public void test15() throws InterruptedException
{
	Thread.sleep(1000);
	Advancepage a=new Advancepage(driver);
	
	//a.freeshipping().click();
	WebElement w=a.freeshipping();
	Actions a1=new Actions(driver);
	a1.click(w).build().perform();
	
	a.localpickup().click();
	test=extent.createTest("testcase15","Select Freeshipping and local pick options");
    AssertJUnit.assertTrue(true);	
    Thread.sleep(1000);
	
}	
/**********************************************************************************
                 Test case for link "Search tips"
/**********************************************************************************/
@Test(priority=15)
public void testcase16() throws InterruptedException
{
	Thread.sleep(1000);
	Advancepage a=new Advancepage(driver);
	a.searchtip_link().click();
	Set<String> window=driver.getWindowHandles();
	List<String>windowlist=new ArrayList<>(window);
	driver.switchTo().window(windowlist.get(1));
	test=extent.createTest("testcase16","Open search tip link in new window");
	AssertJUnit.assertEquals(driver.getCurrentUrl(),"https://www.ebay.com/pages/help/buy/contextual/search_tips.html");
	// AssertJUnit.assertTrue(true);	
	driver.switchTo().window(windowlist.get(0));
	Thread.sleep(1000);
}
/**********************************************************************************
                    Test case to verify clear options
**********************************************************************************/
@Test(priority=16)
public void testcase17() throws InterruptedException
{
	Thread.sleep(1000);
	Advancepage a=new Advancepage(driver);
	a.keyword().sendKeys("toys");
	
	a.clearoptions().click();
	test=extent.createTest("testcase17","Check clear options using mouse actions");
    AssertJUnit.assertTrue(true);	
    Thread.sleep(1000);
}

/**********************************************************************************
        Test case to select "Buy it now" in  Buying Format
/**********************************************************************************/
@Test(priority=17)
public void testcase18() throws InterruptedException
{
Thread.sleep(1000);
Advancepage a=new Advancepage(driver);
WebElement w=a.buyingformat();
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("window.scrollTo(250,1000)");
js.executeScript("arguments[0].click(0);", w);
test=extent.createTest("testcase18","Select buy it now format using java script executor");
AssertJUnit.assertTrue(true);	
Thread.sleep(1000);

}

/**********************************************************************************
              Test case to View results in Gallery View
/**********************************************************************************/
@Test(priority=18)
public void testcase19() throws InterruptedException
{
	
	Thread.sleep(1000);
	Advancepage a=new Advancepage(driver);
	WebElement viewresult=a.viewresults();
	Select view=new Select(viewresult);
	a.keyword().sendKeys("samsung phone");
	view.selectByVisibleText("Gallery view");;
	a.finalsearch().click();
	
	test=extent.createTest("testcase19","See list in Gallery view");
	AssertJUnit.assertTrue(true);	
	Thread.sleep(1000);

	}
/**********************************************************************************
              Test case to search view results per page as "60"
/**********************************************************************************/
@Test(priority=19)
public void testcase20() throws InterruptedException
{
	
	Thread.sleep(1000);
	Advancepage a=new Advancepage(driver);
	WebElement itemsperpage=a.itemsperpage();
	Select page=new Select(itemsperpage);
	page.selectByVisibleText("60");
	a.finalsearch().click();
	test=extent.createTest("testcase20","Result per page '60' using java script executor");
	AssertJUnit.assertTrue(true);	
	Thread.sleep(1000);
}




	@AfterMethod(alwaysRun=true)
	 
	public void getResult(ITestResult result) throws InterruptedException
	{
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,result.getThrowable());
			}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,result.getThrowable());	
		}
		else
		{
			test.log(Status.SKIP,result.getThrowable());
		}

		driver.close();
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void teardown() throws InterruptedException
	{    
		Thread.sleep(1000);
		extent.flush();
	}
	
}
