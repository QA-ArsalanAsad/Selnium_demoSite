package com.qa.site;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoTest {
	
	private static RemoteWebDriver driver;
	private static WebElement targ;
	
	@BeforeAll
	public static void setUp() {
		System.setProperty(
				"webdriver.chrome.driver",
				"src/test/resources/drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver(chromeCfg());
		
	}
	
	@AfterAll
	public static void cleanUp() {
		driver.quit();
	}
	
	@Test
	void testLogin() throws InterruptedException {
		driver.get("http://www.thedemosite.co.uk/");
		
		targ = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		
		targ.click();
		
		targ = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		targ.sendKeys("guest");
		
		targ = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		targ.sendKeys("guest");
		
		targ = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		targ.submit();
		
		targ = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		targ.click();
		
		targ = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		targ.sendKeys("guest");
		
		targ = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		targ.sendKeys("guest");
		
		targ = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		targ.submit();
		
		targ = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		
		Thread.sleep(5000);
		
		
		
		
	}
	
	public static ChromeOptions chromeCfg() {
		 Map<String, Object> prefs = new HashMap<String, Object>();
		 ChromeOptions cOptions = new ChromeOptions();
		  
		 // Settings
		 prefs.put("profile.default_content_setting_values.cookies", 2);
		 prefs.put("network.cookie.cookieBehavior", 2);
		 prefs.put("profile.block_third_party_cookies", true);

		 // Create ChromeOptions to disable Cookies pop-up
		 cOptions.setExperimentalOption("prefs", prefs);
		 cOptions.addArguments("test-type");
		 cOptions.addArguments("start-maximized");
		 cOptions.addArguments("--js-flags=--expose-gc");
		 cOptions.addArguments("--enable-precise-memory-info");
//		 cOptions.addArguments("--disable-popup-blocking");
		 cOptions.addArguments("--disable-default-apps");
		 cOptions.addArguments("test-type=browser");    
		 cOptions.addArguments("disable-infobars");

		 return cOptions;
		 }


}
