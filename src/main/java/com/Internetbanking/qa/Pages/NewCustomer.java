package com.Internetbanking.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Intenerbanking.qa.Base.TestBase;

public class NewCustomer extends TestBase
{
	
	@FindBy(xpath="//input[@name='name']")
	WebElement custName;
	
	@FindBy(xpath="//input[@type='radio' and @value='m']")
	WebElement maleRadio;
	
	@FindBy(xpath="//input[@type='radio' and @value='f']")
	WebElement femaleRadio;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement pinno;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement mobno;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']") 
	WebElement newCusetPassword;
	
	@FindBy(xpath="//input[@type='reset']")
	WebElement resetButton;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//p[@class='heading3' and contains(text(),'Add New Customer')]")
	WebElement pageText;
	

	public NewCustomer() throws IOException 
	{
		super();
		
		PageFactory.initElements(driver, this);
	}
	
	public String getPageText()
	{
		String strText = pageText.getText();
		return strText;
	}
	
	public void clickonSubmit() throws InterruptedException
	{
		custName.sendKeys("John Cleaner");
		boolean radio = maleRadio.isSelected();
		System.out.println("Radio Button selected - " + radio);
		
		address.sendKeys("West Coast Road, See View Residency, LA");
		city.sendKeys("Los Angeles");
		state.sendKeys("California");
		pinno.sendKeys("411038");
		mobno.sendKeys("7896541235");
		email.sendKeys("abc@gmail.com");
		newCusetPassword.sendKeys("Califor@1981");
		
		Thread.sleep(1000);
		
		resetButton.click();
	}

}
