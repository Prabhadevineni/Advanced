package HDFC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Cupon {
@Test	
	public void cupon () {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b6b.01.09\\Downloads\\Selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		driver.findElementsByXPath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a").get(0).click();
		
		driver.findElementById("Email").sendKeys("prabhakar.devineni@accenture.com");
		driver.findElementById("Password").sendKeys("Nov@2018");
		driver.findElement(By.cssSelector("input[value='Log in")).click();
		
		driver.close                                                                                                                                                                                                                                                                                                                         ();
	   // driver.findElements(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).get(0).click();
		
	}

}
