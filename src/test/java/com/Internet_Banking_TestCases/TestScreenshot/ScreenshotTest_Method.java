package com.Internet_Banking_TestCases.TestScreenshot;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Intenerbanking.qa.Base.TestBase;
import com.Internet_Banking_TestCases.ItestListener_Method;

@Listeners(ItestListener_Method.class)

public class ScreenshotTest_Method extends TestBase 
{

	public ScreenshotTest_Method() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
	}
	
	@Test
	public void screenshotTest()
	{
		Assert.assertEquals(false, true);
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.close();
	}

}
