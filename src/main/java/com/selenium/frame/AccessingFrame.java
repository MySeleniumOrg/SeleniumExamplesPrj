package com.selenium.frame;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AccessingFrame {

	private static WebDriver driver = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Test
	public void test() {
		driver.get("http://site21.way2sms.com/content/index.html");
		driver.findElement(By.name("username")).sendKeys("8008387233");
		driver.findElement(By.name("password")).sendKeys("omsairam");
		driver.findElement(By.id("loginBTN")).click();
		//click on send free sms button
		driver.findElement(By.xpath("//*[@id=\"ebFrm\"]/div[2]/div[1]/input")).click();
		
		
		
		driver.findElement(By.xpath("//*[@id=\"sendSMS\"]/a")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.switchTo().frame("frame");
		
		driver.findElement(By.cssSelector("#mobile")).sendKeys("8008387233");
		driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("msg sent thru automation");
		driver.findElement(By.id("Send")).click();
	}

}
