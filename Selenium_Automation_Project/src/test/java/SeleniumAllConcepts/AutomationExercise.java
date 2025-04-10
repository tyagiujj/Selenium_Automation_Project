package SeleniumAllConcepts;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationExercise {
	WebDriver driver;
	@BeforeClass
	public void Setup() {
		driver = new ChromeDriver();	
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	@Test(priority=1)
	public void VerifyTheUserNameFunctionality() {
		WebElement UserName = driver.findElement(By.id("username"));
		boolean username = UserName.isEnabled();
		Assert.assertTrue(username, "UserName Text Field is Not Enabled");
		UserName.sendKeys("student");
	}
	@Test(priority=2,dependsOnMethods = "VerifyTheUserNameFunctionality")
	public void VerifyTheUserNameLabel() {
		WebElement UserNameLabel = driver.findElement(By.xpath("//label[text()=\"Username\"]"));
		String LabelName = UserNameLabel.getText();
		Reporter.log("Label Name is : " + LabelName, true);
		Assert.assertEquals(LabelName, "Username", "Label is not As per Expected Result");
	}   
	@Test(priority=3,dependsOnMethods = "VerifyTheUserNameLabel")
	public void VerifyTheTitleOfThePage() {
		String TitleofThePage = driver.getTitle();
		Reporter.log("Title of The Page is : " + TitleofThePage, true);
		Assert.assertEquals(TitleofThePage, "Test Login | Practice Test Automation");
	}
	@Test(priority=4,dependsOnMethods = "VerifyTheTitleOfThePage")
	public void VerifyTheURLofThePage() {
		String URLofThePage = driver.getCurrentUrl();
		Reporter.log("URL of The Page is : " + URLofThePage, true);
		Assert.assertEquals(URLofThePage, "https://practicetestautomation.com/practice-test-login/");
	}
	@Test(priority=5,dependsOnMethods = "VerifyTheURLofThePage")
	public void VerifyThePasswordFunctionality() {
		WebElement Password = driver.findElement(By.id("password"));
		boolean password = Password.isEnabled();
		Assert.assertTrue(password, "Password Text Field is not Enabled");
		Password.sendKeys("Password123");
	}
	@Test(priority=6,dependsOnMethods = "VerifyThePasswordFunctionality")
	public void VerifyTheSubmitButtonFunctionality() {
		WebElement Submit = driver.findElement(By.id("submit"));
		boolean submit = Submit.isDisplayed();
		Assert.assertTrue(submit, "Submit Button is not Display");
		boolean Button = Submit.isEnabled();
		Assert.assertTrue(Button, "Submit Button is not Enabled");
		Submit.click();
	}
	@Test(priority=7,dependsOnMethods = "VerifyTheSubmitButtonFunctionality")
	public void VerifyLoginSuccessMessage() {
		WebElement Message = driver.findElement(By.xpath("//strong[text()=\"Congratulations student. You successfully logged in!\"]"));
		String SuccessMessage = Message.getText();
		Reporter.log("Success Message is : " + SuccessMessage, true);
		boolean message = Message.isDisplayed();
		Assert.assertTrue(message, "Success Message is not Display");
	}
	@Test(priority=8,dependsOnMethods = "VerifyLoginSuccessMessage")
	public void VerifyTheLogOutButtonFunctionality() {
		WebElement LogOut = driver.findElement(By.xpath("//a[normalize-space()='Log out']"));
		boolean logout = LogOut.isDisplayed();
		Assert.assertTrue(logout, "LogOut Button is Not Display");
	}
	@Test(priority=0)
	public void VerifytheApplicationLogo() {
		WebElement Logo= driver.findElement(By.xpath("//img[@alt='Practice Test Automation']"));
		boolean logo= Logo.isDisplayed();
		Assert.assertTrue(logo, "Application Logo is not Dispaly");
	}
	@Test(priority=9)
	public void NumberofLink() {
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		int NumberofLink = Links.size();
		Reporter.log("Number of Link in This Page is : " + NumberofLink );
		for(WebElement link : Links) {
			Reporter.log("Name of The Links is : " + link.getText());
		}
		  Assert.assertEquals(NumberofLink, 10, "Unexpected number of links on the page.");
	}
	@AfterClass
	public void TearDown() {
		driver.quit();
	}
}
