package com.flipkart.Testcase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.flipkart.keyword.Keyword;

public class TestCase1 
{
	@BeforeSuite
	public void Tc_01() throws InterruptedException 
	{
		Keyword.OpenBrowser("Chrome");
		Keyword.Openurl("s");
	    Keyword.driver.manage().window().maximize();
	   Keyword.Loginpage();
	    
	}
	@Test
	public void Tc_02() throws InterruptedException
	{
		Keyword.Women();
		Keyword.Item();
	}
	@AfterTest
	public void Tc_03()
	{
		Keyword.SelectItem();
	}
}
