package com.travel.spicejet;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.spicejet.genericUtility.IConstantPath;
import com.spicejet.genericUtility.PropertyFileKeys;
import com.spicejet.genericUtility.PropertyFileUtility;
import com.spicejet.genericUtility.WebDriverUtility;
import com.spicejet.objectRepository.BookRoundTrip;
import com.spicejet.objectRepository.FlightBookingPage;

public class BookingFlight {

	public static void main(String[] args) throws InterruptedException {
		
		PropertyFileUtility fu=new PropertyFileUtility();	
		fu.openPropertyFile(IConstantPath.PROPERTY_PATH);
		String browser=fu.getPropertyFileData(PropertyFileKeys.BROWSER.convertToString());
		String url=fu.getPropertyFileData(PropertyFileKeys.URL.convertToString());
		WebDriverUtility wdu=new WebDriverUtility();
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		WebDriver driver=wdu.launchApplication(browser, 10,url, co );
		
		BookRoundTrip brt=new BookRoundTrip(driver);
		brt.roundTripClick();
		brt.fromTo("BOM", "BLR");
		brt.delC(url, browser, url, driver);
		brt.calHandle();
		brt.clickPass();
		brt.clickChildBtn();
		brt.clickSearchFlight();
		
//		FlightBookingPage fbp=new FlightBookingPage();
//		String replaceData="SG 475, SG 2910";
//		WebElement flightDetails=fbp.selectFlight(driver,replaceData);
//		if(flightDetails.getText().equals(replaceData)) {
			
		}
		
		
		
		
		
		
	}
	}


