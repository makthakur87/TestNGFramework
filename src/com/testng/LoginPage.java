package com.testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// This is the Page File in which we declare all the methods and put variable in all methods

public class LoginPage 
{
	WebDriver driver;
	@FindBy(id ="identifierId")
	public static WebElement email;
	
	@FindBy(xpath = "//*[@id='identifierNext']/content/span")
	public static WebElement emailNext;
	
	@FindBy(name = "password")
	public static WebElement pasword;
	
	@FindBy(xpath = "//*[@id='passwordNext']/content/span")
	public static WebElement passwordNext;
	
	@FindBy(xpath = ".//*[@jsname='B34EJ']")
	public static WebElement emailErrorMsg;
	
	@FindBy(xpath = "//*[@id='password']/div[2]/div[2]")
	public static WebElement passwordErrorMsg;
	
	public void openBrowser() throws IOException
	{
	//driver = new FirefoxDriver();
		FileInputStream fs=new FileInputStream("C:\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(fs);
		
		String browser = prop.getProperty("browser");
		if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} 
		else if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\SeleniumJars\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else
			
			
		{
			System.setProperty("webdriver.ie.driver","C:\\SeleniumJars\\IEDriverServer.exe" );
			driver = new InternetExplorerDriver();
		}
		PageFactory.initElements(driver, this);
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public void openGmail()
	{
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
		
	public void enterEmail(String a) throws InterruptedException
	{
		email.sendKeys(a);
		emailNext.click();
		
		Thread.sleep(3000);
	}
	
	public void enterPassword(String b) throws InterruptedException
	{
		pasword.sendKeys(b);
		passwordNext.click();
			
		Thread.sleep(3000);
	}
	
	public String readEmailErrorsMsg()
	{
		String actualErrorMsg = emailErrorMsg.getText();
		System.out.println(actualErrorMsg);
		return actualErrorMsg;
	}
	
	public String readPasswordErrorsMsg()
	{
		String actualErrorMsg = passwordErrorMsg.getText();
		System.out.println(actualErrorMsg);
		return actualErrorMsg;
	}
}
