package com.spicejet.genericUtility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	private WebDriver driver;
	PropertyFileUtility fu=new PropertyFileUtility();
	//String timeout=fu.getPropertyFileData(PropertyFileKeys.TIMEOUT.convertToString());
	//JavaLibrary jv=new JavaLibrary();
	//long sec=jv.converStringToLong(timeout);
	
	/**
	 * Use to launch Application 
	 * @param browser
	 * @param timeout
	 * @param url
	 * @return
	 */
	public WebDriver launchApplication(String browser, long timeout, String url, ChromeOptions option ) {
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(option);
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Please enter valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
		}
	
	/**
	 * Used for explicit wait
	 * @param typeWait
	 * @param element
	 */
	public void explicitWait(String typeWait, By element)
	{
		if(typeWait.equals("presenceOfElementLocated")){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		
		}
		else if(typeWait.equals("alertIsPresent")) {
			WebDriverWait wait1=new WebDriverWait(driver,10);
			wait1.until(ExpectedConditions.alertIsPresent());

		}
	}
	
	/**
	 * Used for alert popup handling
	 * @return
	 */
	public Alert alertPopUp()
	{
		Alert a1 = driver.switchTo().alert();
		return a1;
	}
	
//	public WebDriver disableNotification() {
//		ChromeOptions co=new ChromeOptions();
//		co.addArguments("--disable-notifications");
//		driver=new ChromeDriver(co);
//		return driver;
//}
}