package com.selenium.frame;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CapitalOneLoginFrame {

	private static WebDriver driver = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("https://servicing.capitalone.com/c1/login.aspx");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.switchTo().frame("loginframe");
		
		driver.findElement(By.name("username")).sendKeys("Sasidhars");
		driver.findElement(By.name("password")).sendKeys("Winter2007");
		driver.findElement(By.id("cofisso_btn_login")).click();
		
	}

}
