package HDFC;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NewTest {
//	WebDriver driver;
  @Test
	  public void HDFC() throws InterruptedException {
		  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\training_b6b.01.09\\Downloads\\Selenium\\chromedriver.exe");
		  ChromeDriver driver = new ChromeDriver();
		  driver.get("https://www.hdfcbank.com/");
		  
		  Actions act1 = new Actions(driver);
		  act1.moveToElement(driver.findElement(By.cssSelector("a[href ='/personal/products']"))).perform();
		  Thread.sleep(2000);
		 // act1.moveToElement(driver.findElement(by))
		  driver.close();
		  
	  }
	
  }
  



