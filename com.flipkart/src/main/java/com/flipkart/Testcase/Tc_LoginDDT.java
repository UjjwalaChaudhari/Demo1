/*
 * package com.flipkart.Testcase;
 * 
 * public class Simple { package Fileutility;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.io.IOException;
 * 
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.xssf.usermodel.XSSFCell; import
 * org.apache.poi.xssf.usermodel.XSSFRow; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * public class XLUtility { public static FileInputStream fis; //public static
 * Workbook wb; public static XSSFSheet ws; public static XSSFWorkbook wb;
 * public static XSSFRow row; public static XSSFCell c;
 * 
 * 
 * public static int getrowcount(String xfile,String xsheet) throws Exception {
 * fis=new FileInputStream(xfile); wb=new XSSFWorkbook(fis);
 * ws=wb.getSheet(xsheet); int rowcount=ws.getLastRowNum(); fis.close();
 * //wb.close(); return rowcount; } public static String getcelldata(String
 * xfile,String xsheet,int rownum,int col) throws Exception { fis=new
 * FileInputStream(xfile); wb=new XSSFWorkbook(fis); ws=wb.getSheet(xsheet);
 * row=ws.getRow(rownum); c=row.getLastCell(col); String data;
 * 
 * 
 * }
 * 
 * public static int getcellcount(String xfile,String xsheet,int rownum) throws
 * Exception { fis=new FileInputStream(xfile); wb=new XSSFWorkbook(fis);
 * ws=wb.getSheet(xsheet); row=ws.getRow(rownum); int
 * cellcount=row.getLastCellNum(); fis.close(); //wb.close(); return cellcount;
 * }
 * 
 * }
 * 
 * }
 */


package com.flipkart.Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.keyword.Constant;
import com.flipkart.keyword.Keyword;

import Fileutility.XLUtility;

public class Tc_LoginDDT {

@Test(dataProvider="Logindata")
public void loginddt() 
{
	//Keyword k=new Keyword(Constant.driver); 
	//k.enterusername();
	//k.enteruserpassword();
	
 if(isAlertpresent()==true)
 {
	 Constant.driver.switchTo().alert().accept();
	 Constant.driver.switchTo().defaultContent();
	 Assert.assertTrue(false);
 }
 else {
	 Assert.assertTrue(true);
	 Constant.driver.findElement(By.xpath("//*[@id='nav-link-accountList']")).click();
	 Constant.driver.findElement(By.xpath("//*[@id='nav-item-signout']/span")).click();
	 Constant.driver.switchTo().alert().accept();
	 Constant.driver.switchTo().defaultContent();
	 
 }
}
public boolean isAlertpresent() 
{ try {
	Constant.driver.switchTo().alert();
	return true;	
	}
	catch(NoAlertPresentException e) {
		return false;
	}
}
	@DataProvider(name="Logindata")
	public String[][] getdata() throws Exception 
	{
	String path=System.getProperty("user.dir")+"\\src\\test\\resources\\Data.xlsx";
	int rownum=XLUtility.getrowcount(path,"Sheet1");
	int colcount=XLUtility.getcellcount(path,"Sheet1",1);
	String logindata[][] = new String[rownum][colcount];
	for(int i=1;i<=rownum;i++) {
		for(int j=0;j<colcount;j++) {
			logindata[i-1][j]=XLUtility.getcelldata(path,"Sheet1",i,j);
		}
	}
		return logindata;
	}
}
