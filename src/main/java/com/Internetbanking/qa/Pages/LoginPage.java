package com.Internetbanking.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Intenerbanking.qa.Base.TestBase;

public class LoginPage extends TestBase
{
	//Page Factory
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement userPwd;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//div/h2[contains(text(),'Guru99 Bank')]")
	WebElement loginPageLogo;

	public LoginPage() throws IOException
	{
		super();
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public boolean pageLogo()
	{
		return loginPageLogo.isDisplayed();
	}
	
	public HomePage login(String uname, String pwd) throws IOException, InterruptedException
	{
		username.sendKeys(uname);
		Thread.sleep(1000);
		userPwd.sendKeys(pwd);
		Thread.sleep(1000);
		btnSubmit.click();
		
		return new HomePage();
	}
	
	

}
