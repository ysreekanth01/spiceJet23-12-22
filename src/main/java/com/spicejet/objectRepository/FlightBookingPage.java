package com.spicejet.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightBookingPage {
	
	String partialXpath="//div[text()='%s']";
	
	public WebElement selectFlight(WebDriver driver, String  replaceData) {
		String xpath= String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
		
}
	
	
}
