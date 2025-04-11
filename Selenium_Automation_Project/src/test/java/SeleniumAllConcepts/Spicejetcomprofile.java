package SeleniumAllConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Spicejetcomprofile {
	WebDriver driver;
	@BeforeClass
	public void Seup() {
		driver= new ChromeDriver();
		driver.get("https://www.spicejet.com/profile/sign-up/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(priority=1)
	public void VerifyTheURL() {
		String CurrentURL= driver.getCurrentUrl();
		Reporter.log("Current URL of The Application is : "  + CurrentURL);
		System.out.println("Current URL of The Application is : " + CurrentURL);
		Assert.assertEquals(CurrentURL, "https://www.spicejet.com/profile/sign-up/");
	}
	@Test(priority=2)
	public void TitleofThePage() {
		String TitleOfThePage= driver.getTitle();
		Reporter.log("Title of The Application is : " + TitleOfThePage);
		System.out.println("Title of The Application is : " + TitleOfThePage);
		Assert.assertEquals(TitleOfThePage, "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets", "Title is not Match");
	}
	@Test(priority=3)
	public void VerifyNumberOfLink() {
		List<WebElement> NumberOfLink = driver.findElements(By.tagName("a"));
		Reporter.log("Number of Link in This Application is : " + NumberOfLink.size());
		System.out.println("Number of Link in This Application is : " + NumberOfLink.size());
		
		for(WebElement LinkName : NumberOfLink) {
			System.out.println("Name of All Link is : " + LinkName.getText());
			Reporter.log("Name of All Link is : " + LinkName.getText());
			Assert.assertEquals(NumberOfLink.size(), 42);
		}
	}
	@Test(priority=4)
	public void VerifyNumberOfImage() {
		List<WebElement> NumberOfImages= driver.findElements(By.tagName("img"));
		System.out.println("Number of Images is : " + NumberOfImages.size());
		Reporter.log("Number of Images is : " + NumberOfImages.size());
		Assert.assertEquals(NumberOfImages.size(), 23);
	}
	@Test(priority = 5)
	public void verifyTheLogoOfApplication() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement logoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//a[normalize-space()='']//img[@class='css-9pa8cd']")));

	        boolean isLogoDisplayed = logoElement.isDisplayed();
	        Assert.assertTrue(isLogoDisplayed, "Logo of the application is not displayed.");
	    } catch (TimeoutException e) {
	        Assert.fail("Logo did not appear within the expected time. Check if it's loaded properly.");
	    } catch (NoSuchElementException e) {
	        Assert.fail("Logo element not found. Please verify the XPath.");
	    } catch (Exception e) {
	        Assert.fail("An unexpected error occurred: " + e.getMessage());
	    }
	}
	@Test(priority = 6)
	public void verifyTheEnrollFunctionality() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//input[@placeholder='e.g. John']")));
	        firstName.sendKeys("Ujjwal Tyagi");
	    } catch (NoSuchSessionException e) {
	        Assert.fail("WebDriver session is invalid or closed. Make sure the browser is launched before this test.");
	    } catch (NoSuchElementException e) {
	        Assert.fail("The First Name input field was not found. Check the XPath.");
	    } catch (TimeoutException e) {
	        Assert.fail("The First Name input field was not visible within the expected time.");
	    } catch (Exception e) {
	        Assert.fail("Unexpected error: " + e.getMessage());
	    }
	}


}
