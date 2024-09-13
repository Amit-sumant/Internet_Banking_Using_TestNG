package com.Internet_Banking_TestCases;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Intenerbanking.qa.Base.TestBase;

public class ItestListener_Method extends TestBase implements ITestListener
{

	public ItestListener_Method() throws IOException
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Failed Test Cases");
		try 
		{
			failedTestCases();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
