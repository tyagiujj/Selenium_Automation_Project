package SeleniumAllConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FakeAlert {
	WebDriver driver;
	Duration globalWait = Duration.ofSeconds(10); 

	@BeforeClass
	public void Setup() {
		driver = new ChromeDriver();
		driver.navigate().to("https://testpages.eviltester.com/styled/alerts/fake-alert-test.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(globalWait);
	}
	@Test(priority = 1)
	public void HandleFakeAlert() throws InterruptedException {
		WebElement fakeAlertButton = driver.findElement(By.id("fakealert"));
		fakeAlertButton.click();
		WebElement okButton = driver.findElement(By.id("dialog-ok"));
		//System.out.println("Fake Alert Text: " + fakeAlertButton.getText());
		okButton.click();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
