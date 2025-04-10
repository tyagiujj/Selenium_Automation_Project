package SeleniumAllConcepts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddMedia {
	WebDriver driver;

	@BeforeClass
	public void Setup() {
		// driver= new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1024,1024");
		driver = new ChromeDriver(options);
		driver.navigate().to("https://dev.myschoolone.com/newworldschool");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys("admin@mso786");
		driver.findElement(By.name("password")).sendKeys("38024008ec29");
		driver.findElement(By.id("imrobot")).click();
		WebElement button = driver.findElement(By.xpath("//a[contains(text(),'Sign')]"));
		button.click();
	}

	@Test(priority = 1)
	public void NavigatetoAddLibraryPage() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().to("https://dev.myschoolone.com/Web/Library/library_addmedia.php");
		String URLofThePage = driver.getCurrentUrl();
		Reporter.log("URL of The Add Library Page is : " + URLofThePage, true);
		Assert.assertEquals(URLofThePage, "https://dev.myschoolone.com/Web/Library/library_addmedia.php");
	}
	@Test(priority = 2)
	public void TitleofThePage() {
		String TitleofThePage = driver.getTitle();
		Reporter.log("Title of The Page is : " + TitleofThePage, true);
		Assert.assertEquals(TitleofThePage, "MySchoolOne");
	}
	@Test(priority = 3)
	public void titleOfSubmodule() {
		WebElement titleOfSubmodule = driver.findElement(By.xpath("//h4[text()='Add Media']"));
		String actualTitle = titleOfSubmodule.getText();
		Reporter.log("Title of Submodule is: " + actualTitle, true);
		Assert.assertEquals(actualTitle, "Add Media", "Submodule title does not match!");
	}
	@Test(priority = 4)
	public void SelectTheLibrary() throws InterruptedException {
		WebElement Library = driver.findElement(By.name("library"));
		Select lib = new Select(Library);
		lib.selectByVisibleText("Middle School");
	}
	@Test(priority = 5)
	public void Registration() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type_id")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("type_id")));
		WebElement registrationDropdown = driver.findElement(By.id("type_id"));
		Select reg = new Select(registrationDropdown);
		reg.selectByVisibleText("library 1");
	}

	@Test(priority = 6)
	public void NoCopies() {
		WebElement NoCopies = driver.findElement(By.name("copies"));
		boolean Copies = NoCopies.isEnabled();
		Assert.assertTrue(Copies, "No of Copies Text Field is not Enabled");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='3';", NoCopies);
	}

	@Test(priority = 7)
	public void GetAttribute() {
		WebElement GetAttributeCopies = driver.findElement(By.name("copies"));
		Reporter.log("Value of Attribure is : " + GetAttributeCopies.getAttribute("type"), true);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	@AfterClass
	public void TearDown() {
		driver.quit();
	}
}
