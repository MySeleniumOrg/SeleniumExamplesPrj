package com.selenium.wait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchWebDriverWait {

	WebDriver driver = null;
	static Wait<WebDriver> wait;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 5);

	}



	@Test
	public void testExpectedCondition() {
		driver.get("http://www.google.com");

		WebElement element = driver.findElement(By.name("q"));

		element.sendKeys("Cheese!");

		driver.findElement(By.name("btnG")).click();

		// Wait for search to complete

		wait.until(new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver webDriver) {

				System.out.println("Searching ...");

				return webDriver.findElement(By.id("resultStats")) != null;

			}

		});

		Assert.assertEquals("Cheese! - Google Search", driver.getTitle());
	}
	
	@Test
	public void testThreadSleep() throws InterruptedException {
		driver.get("http://www.google.com");

		WebElement element = driver.findElement(By.name("q"));

		element.sendKeys("Cheese!");

		driver.findElement(By.name("btnG")).click();

		Thread.sleep(15000);

		Assert.assertEquals("Cheese! - Google Search", driver.getTitle());
	}

	@Test
	public void testImplicitlyWait() throws IOException {
		driver.get("http://www.google.com");

		WebElement element = driver.findElement(By.name("q"));

		element.sendKeys("Cheese!");

		driver.findElement(By.name("btnG")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));

		Assert.assertEquals("Cheese! - Google Search", driver.getTitle());
	}
	@After
	public void close() {
		driver.quit();
	}
}
