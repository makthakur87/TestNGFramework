package com.testng;

public class DataFile 
{
	Xls_Reader reader = new Xls_Reader("C:\\Testing\\NikulTest.xlsx");
			
			//login data
			String rightEmail = reader.getCellData("Data1", "UserName", 2);
			String wrongEmail = reader.getCellData("Data1", "UserName", 3);
			
			String password = reader.getCellData("Data1", "Password", 2);
			String emailError = reader.getCellData("Data1", "Email Error", 3);
			String passwordError = reader.getCellData("Data1", "Password Error", 1);
			
			//home page data
			
			//footer data
}
