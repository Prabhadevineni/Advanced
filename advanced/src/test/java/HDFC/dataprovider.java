package HDFC;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bsh.Remote;

public class dataprovider {
	
	WebDriver driver;
	
	@Test (dataProvider = "dp1")
	public void Test(String Uname, String Pass) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\training_b6b.01.09\\Downloads\\Selenium\\chromedriver.exe");
		  ChromeDriver driver = new ChromeDriver();
		  driver.get("http://demowebshop.tricentis.com/");
		  driver.manage().window().maximize();
		  driver.findElementsByXPath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a").get(0).click();
			
			driver.findElementById("Email").sendKeys(Uname);
			driver.findElementById("Password").sendKeys(Pass);
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("input[value='Log in")).click();
			
			//assert.assertEquals(Logind, actual);
	
	}
	
	@BeforeClass
	@Parameters({"node"})
	public void hub (String nodevalue) throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\training_b6b.01.09\\Downloads\\Selenium\\chromedriver.exe");
		
		DesiredCapabilities DC = new DesiredCapabilities();
		DC.setPlatform(Platform.ANY);
		driver = new RemoteWebDriver(new URL(nodevalue),DC);
		
	}
	
	
	
		@DataProvider(name ="dp1")
	public Object[][] getDataValidUsers(){
		
		Object[][] obj = new Object [2][];
		
		File file = new File("test.xlsx");
		 try {
			InputStream IS = new FileInputStream(file);//Stream is creatred 
			XSSFWorkbook WB = new XSSFWorkbook(IS); //Steam as workbook
			XSSFSheet sheet = WB.getSheet("sheet1");
			for (int i=1; i<=sheet.getLastRowNum(); i++) {
				
				obj[i-1] = new Object[sheet.getRow(i).getPhysicalNumberOfCells()];
				obj[i-1][0] = sheet.getRow(i).getCell(0).getStringCellValue();
				obj[i-1][1] = sheet.getRow(i).getCell(1).getStringCellValue();
										
			}

}catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
		return obj;
	}
}
