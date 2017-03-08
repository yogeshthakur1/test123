package news;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class NewTest {
  @BeforeMethod
  public static void Setup() throws EncoderException
	 {
		 
		 System.setProperty("webdriver.gecko.driver","E:\\QA Document\\Selenium\\geckodriver.exe");
			
		 TestScript04.driver=new FirefoxDriver();
		String baseUrl=Util.BASE_URL;
		 
		 TestScript04.driver.manage().timeouts()
		 .implicitlyWait(Util.WAIT_TIME,TimeUnit.SECONDS);
		 TestScript04.driver.get(baseUrl);
		 
	 }

   
		 @Test(dataProviderClass=TestScript04.class,dataProvider="GuruTest")
		 public void login(String U, String P) throws IOException
		 {
//Enter Username
			 TestScript04.driver.findElement(By.name("uid")).sendKeys(U);
		//Enter password
			 TestScript04.driver.findElement(By.name("password")).sendKeys(P);
		//Click on the submit button
			 TestScript04.driver.findElement(By.name("password")).submit();
	File Srcfile=((TakesScreenshot)TestScript04.driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(Srcfile, new File("E:\\QA\\screenshot5.png"));
		 }
		 @Test(dataProviderClass=TestScript04.class,dataProvider="GuruTest")
		 public void login1(String U, String P) throws IOException
		 {
//Enter Username
			 TestScript04.driver.findElement(By.name("uid")).sendKeys(U);
		//Enter password
			 TestScript04.driver.findElement(By.name("password")).sendKeys(P);
		//Click on the submit button
			 TestScript04.driver.findElement(By.name("password")).submit();

	           File scrFile = ((TakesScreenshot)TestScript04.driver).getScreenshotAs(OutputType.FILE);
	        //The below method will save the screen shot in d drive with name "screenshot.png"
	           FileUtils.copyFile(scrFile, new File("E:\\QA\\screenshot6.png"));
		//Close the browser
		 }
		
		 @AfterMethod
		 public void tearsdown()
		 {
			 TestScript04.driver.quit(); 
			 //TestScript04.driver.quit();
		 }
}
