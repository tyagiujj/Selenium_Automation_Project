package SeleniumAllConcepts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class TestPageAlert {

	WebDriver driver;
	Duration globalWait = Duration.ofSeconds(10); 

	@BeforeClass
	public void Setup() {
		driver = new ChromeDriver();
		//driver= new EdgeDriver();
          //driver= new FirefoxDriver();
		driver.navigate().to("https://testpages.eviltester.com/styled/alerts/alert-test.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(globalWait);
	}
	@Test(priority = 1)
	public void VerifyTheSimpleAlert() {
		WebElement simpleAlert = driver.findElement(By.id("alertexamples"));
		simpleAlert.click();
		Alert alert= driver.switchTo().alert();
		System.out.println("Text Message on Simple Alert : " + alert.getText());
		Reporter.log("Text Message on Simple Alert : " + alert.getText());
		String TextMessage= alert.getText();
		Assert.assertEquals(TextMessage, "I am an alert box!");
		alert.accept();
		System.out.println("Attribute Value of  Show Alert Box is : " + simpleAlert.getAttribute("value"));
	}
	@Test(priority=2)
	public void VerifyTheConfirmAlert() {
		WebElement ConfirmAlert= driver.findElement(By.id("confirmexample"));
		ConfirmAlert.click();
	Alert alt= driver.switchTo().alert();
		System.out.println("Text Message on Confirm Alert : " + alt.getText());
		Reporter.log("Text Message on Confirm Alert : " + alt.getText());
		String TextMessage= alt.getText();
		Assert.assertEquals(TextMessage, "I am a confirm alert");
		//alt.accept();
		alt.dismiss();
	}
	@Test(priority = 3)
	public void PromptAlert() {
	    WebElement promptAlert = driver.findElement(By.id("promptexample"));
	    promptAlert.click();
	    
	    Alert pAlert = driver.switchTo().alert();

	    String textMessage = pAlert.getText();
	    System.out.println("Text Message on Prompt Alert : " + textMessage);
	    Reporter.log("Text Message on Prompt Alert : " + textMessage);

	    Assert.assertEquals(textMessage, "I prompt you");

	    pAlert.sendKeys(Keys.chord(Keys.CONTROL, "a")); 
	    pAlert.sendKeys("Ujjwal");

	    pAlert.accept(); 
	}
	@AfterClass
	public void TearDown() {
		driver.close();
	}


		
	}

