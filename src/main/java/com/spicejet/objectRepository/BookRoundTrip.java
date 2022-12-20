package com.spicejet.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookRoundTrip {
	
	@FindBy(xpath = "//div[text()='round trip']/parent::div/parent::div/div/*[name()='svg']")
	private WebElement roundTripClick;
	
	@FindBy(xpath = "//div[text()='From']/..//input")
	private WebElement from;
	
	@FindBy(xpath = "//div[text()='To']/parent::div//input")
	private WebElement to;
	
	//@FindBy(xpath="//div[@data-testid='undefined-month-December-2022']//div[@data-testid='undefined-calendar-day-7']")
	//private WebElement depCal;
	
	@FindBy(xpath="//div[@data-testid='undefined-month-December-2022']//div[@data-testid='undefined-calendar-day-12']")
	private WebElement retCal;
	
	@FindBy(xpath = "//div[text()='Passengers']/parent::div//*[name()='svg']")
	private WebElement clickPassenger;
	
	@FindBy(xpath="//div[@data-testid='Children-testID-plus-one-cta']//*[name()='svg']")
	private WebElement clickChildbtn;
	
	@FindBy(xpath = "//div[text()='Search Flight']/..")
	private WebElement clickSearchFlightBtn;
	
	String delCale="//div[@data-testid='undefined-month-%s-%s']//div[@data-testid='undefined-calendar-day-%s']";
	
	public void delC(String month, String year, String date, WebDriver driver) {
		String actualPath1=String.format(delCale,month,year,date );
		driver.findElement(By.xpath(actualPath1)).click();
	}
	public BookRoundTrip(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	public void roundTripClick() {
		roundTripClick.click();}
		
	public void fromTo(String fromData, String toData) {
		from.sendKeys(fromData);
		
		to.sendKeys(toData);
		
	}
	
	public void calHandle() {
		depCal.click();
		retCal.click();
	}
	
	public void clickPass(){
		clickPassenger.click();
	}
	
	public void clickChildBtn() {
		clickChildbtn.click();
		
	}
	public void clickSearchFlight() {
		clickPassenger.click();
		clickSearchFlightBtn.click();
	
	}
		
		
	}
	

