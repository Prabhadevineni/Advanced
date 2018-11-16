package HDFC;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Keyboard {
	
	@Test
	public void key()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b6b.01.09\\Downloads\\Selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		  WebElement search= driver.findElementById("small-searchterms");
		  Actions act = new Actions(driver);
		  act.keyDown(search,Keys.SHIFT).sendKeys("computer").keyUp(Keys.SHIFT).perform();
		 
		//  WebDriverWait wait = new WebDriverWait (search, 20);
		  
	}

}
