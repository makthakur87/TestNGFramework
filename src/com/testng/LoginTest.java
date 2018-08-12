package com.testng;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest
{
	LoginPage loginpage = new LoginPage();
	
	DataFile datafile = new DataFile();

	/*Xls_Reader reader = new Xls_Reader("C:\\Testing\\NikulTest.xlsx");
	String rightEmail = reader.getCellData("Data1", "UserName", 2);
	String wrongEmail = reader.getCellData("Data1", "UserName", 3);
	
	String password = reader.getCellData("Data1", "Password", 2);
	String emailError = reader.getCellData("Data1", "Email Error", 3);
	String passwordError = reader.getCellData("Data1", "Password Error", 2);*/
	
	
	@BeforeMethod
	public void Browser() throws IOException
	{
		loginpage.openBrowser();
		loginpage.openGmail();
	}
	
	@AfterMethod
	public void close_Browser()
	{
		loginpage.closeBrowser();
	}
	
	@Test
	public void enter_wrong_email() throws InterruptedException
	{
		loginpage.enterEmail(datafile.wrongEmail);
		Assert.assertEquals(loginpage.readEmailErrorsMsg(), datafile.emailError);
	}
	
	@Test
	public void enter_wrong_password() throws InterruptedException
	{
		loginpage.enterEmail(datafile.rightEmail);
		loginpage.enterPassword(datafile.password);
		
		Assert.assertEquals(loginpage.readPasswordErrorsMsg(), datafile.passwordError);
	}
}
