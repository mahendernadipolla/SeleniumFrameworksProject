package com.itlearn.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	WebDriver driver;
	public PaymentPage(WebDriver ldriver)
	{
		driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"learn-press-payment\"]/ul/li/label") WebElement stripebtn;
	
	@FindBy(id="learn-press-checkout-place-order") WebElement checkoutbtn;
	
	@FindBy(xpath="//*[@id=\\\"card-element\\\"]/div/iframe") WebElement chckoutframe;
	
	@FindBy(name="cardnumber") WebElement cardnumber;
	
	@FindBy(name="exp-date") WebElement expdate;
	
	@FindBy(name="cvc") WebElement cvc;
	
	@FindBy(xpath="//*[@id=\\\"payment-button\\\"]") WebElement paymentbtn;
	
	
	public void paymentProcess(String crdnumber,String exp,String cvcnumber)
	{
		stripebtn.click();
		checkoutbtn.click();
		
		driver.switchTo().frame(chckoutframe);
		cardnumber.sendKeys(crdnumber);
		expdate.sendKeys(exp);
		cvc.sendKeys(cvcnumber);
		paymentbtn.click();
	}
}
