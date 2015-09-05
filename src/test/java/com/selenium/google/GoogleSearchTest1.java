package com.selenium.google;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class GoogleSearchTest1 {

	WebDriver driver = null;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}

	@Test
	public void test() {
		driver.get("http://www.google.com");

		WebElement element = driver.findElement(By.name("q"));

		element.sendKeys("Cheese!");

		element.submit();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		Assert.assertEquals("Cheese! - Google Search", driver.getTitle());
	}

	@After
	public void close(){
		driver.close();
	}
}
