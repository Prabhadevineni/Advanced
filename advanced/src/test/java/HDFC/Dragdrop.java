package HDFC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Dragdrop {
	
	@Test
	
	public void  Drag(){
		
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\training_b6b.01.09\\Downloads\\Selenium\\chromedriver.exe");
		  ChromeDriver driver = new ChromeDriver();
		  driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		  driver.manage().window().maximize();
		  
		 WebElement from = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
		WebElement To = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_priceChecker\"]/div[1]")); 
		 Actions act = new Actions(driver);
		 
		 act.clickAndHold(from).release(To).perform();
		//Explicit wait
		 WebDriverWait wait = new WebDriverWait (driver,20);
		 wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"), "Drop a package here to check price"));
		
	String Price =	driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
	System.out.println(Price);
	}

}

