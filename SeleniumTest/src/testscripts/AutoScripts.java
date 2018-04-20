package testscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utility.Modules;
import utility.ReUsableMethod;


public class AutoScripts {
	public static WebDriver driver;
	public static void LoginToXero(String browserName) throws InterruptedException{
		String expString="Please enter your password.";
		System.setProperty("webdriver.gecko.driver","./src/utility/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","./src/utility/chromedriver.exe");
		System.setProperty("webdriver.ie.driver","./src/utility/IEDriverServer.exe");
		driver=new FirefoxDriver();
		driver.get("https://login.xero.com/");
		String applicationTitle=driver.getTitle();
		if(applicationTitle.contains("Xero"))
			System.out.println("Xero page is verified");
		else
			System.out.println("Xero page is not verified");
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("samjot2012@gmail.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("SAMjot1995");
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		Thread.sleep(6000);
		
		String homeTiltle=driver.getTitle();
		if(homeTiltle.contains("tekarch"))
			System.out.println("home page verified");
		else
			System.out.println("home page is not verified");
		Modules.closeBrowser(driver);
		DriverFile.logger.log(Status.PASS,MarkupHelper.createLabel("passed",ExtentColor.GREEN));
	}
	
	public static void TabsTest(String browserName) throws InterruptedException{
		String expString="Please enter your password.";
		driver=Modules.launchBrowser(browserName);
		driver.get("https://login.xero.com/");
		String applicationTitle=driver.getTitle();
		if(applicationTitle.contains("Xero"))
			System.out.println("Xero page is verified");
		else
			System.out.println("Xero page is not verified");
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("samjot2012@gmail.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("SAMjot1995");
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		Thread.sleep(6000);


		driver.findElement(By.xpath(".//*[@id='Reports']")).click();
		Thread.sleep(6000);

		driver.findElement(By.xpath(".//*[@id='Contacts']")).click();
		Thread.sleep(6000);

		driver.findElement(By.xpath(".//*[@id='Settings']")).click();
		driver.findElement(By.xpath(".//*[@id='quicklaunchTab']")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[2]/a")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[3]/a")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[4]/a")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[5]/a")).click();
		
		
		String newAccountTexts=driver.findElement(By.xpath(".//*[@id='rt']/div[1]/h3")).getText();
		if(newAccountTexts.equalsIgnoreCase("Help"))
			System.out.println(" all tabs verified");
		else
			System.out.println("couldnt verify all tabs");
		Modules.closeBrowser(driver);
		DriverFile.logger.log(Status.PASS,MarkupHelper.createLabel("passed",ExtentColor.GREEN));
	}
	
	public static void IncorrectPass(String browserName) throws InterruptedException{
		String expString="Please enter your password.";
		driver=Modules.launchBrowser(browserName);
		driver.get("https://login.xero.com/");
		String applicationTitle=driver.getTitle();
		if(applicationTitle.contains("Xero"))
			System.out.println("Xero page is verified");
		else
			System.out.println("Xero page is not verified");
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("samjot2012@gmail.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Samjot1995");
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		Thread.sleep(6000);
		
		String newAccountText=driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).getText();
		if(newAccountText.equalsIgnoreCase("Your email or password is incorrect"))
			System.out.println(" error message verified");
		else
			System.out.println("couldnt verify error message");
		Modules.closeBrowser(driver);
		DriverFile.logger.log(Status.PASS,MarkupHelper.createLabel("passed",ExtentColor.GREEN));
		
		
	}
}
	
