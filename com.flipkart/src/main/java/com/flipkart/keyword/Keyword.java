package com.flipkart.keyword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Keyword 
{
	public static WebDriver driver;
		public static void OpenBrowser(String browserName) 
		{
			switch(browserName)
			{
			 case "Chrome":
				 System.out.println("Opening chrome");
				 System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
				 Keyword.driver=new ChromeDriver();
				break;
					default:
				System.out.println("Invalid browser:"+browserName);
			}
		}
		public static void Openurl(String url) 
		   {
			   System.out.println(url+" is loading...");
			   Keyword.driver.get(url);
		   }
		public static void Loginpage() throws InterruptedException {
			Keyword.driver.manage().window().maximize();
			Keyword.driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
			Keyword.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/a"));
			Keyword.driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("7083155351");
			Thread.sleep(3000);
			Keyword.driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("Abc@123");
			Keyword.driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
			Thread.sleep(4000);
			System.out.println("Login successful");
		    
		    //Thread.sleep(3000);  
		}
		public static void Women() throws InterruptedException
		{
			Actions action=new Actions(Keyword.driver);
			WebElement driver2;
			driver2=driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/ul/li[4]/span"));
			action.moveToElement(driver2);
			driver2.click();
			Thread.sleep(3000);
			action.perform();			
		}
		public static void Item()
		{
			//driver.navigate().refresh();
			Keyword.driver.findElement(By.linkText("Sarees")).click();

		}
		public static void SelectItem()
		{
			driver.navigate().refresh();
			Keyword.driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div/a[2]/div/div[1]")).click();
			Keyword.driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
		}

}