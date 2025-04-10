package SeleniumAllConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumPractice {
	WebDriver driver;

	@BeforeClass
	public void Setup() {
		driver = new ChromeDriver();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void TitleofThePage() {
		String titleOfThePage = driver.getTitle();
		Reporter.log("Title of the Page is: " + titleOfThePage, true);
		Assert.assertEquals(titleOfThePage, "Hands-On Selenium WebDriver with Java");
	}

	@Test(priority = 2)
	public void URLofThePage() {
		String urlOfThePage = driver.getCurrentUrl();
		Reporter.log("URL of the Page is: " + urlOfThePage, true);
		Assert.assertEquals(urlOfThePage, "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
	}

	@Test(priority = 3)
	public void VerifyTitleOfThePageIsDisplayedOnScreen() {
		WebElement title = driver.findElement(By.xpath("//h1[text()='Hands-On Selenium WebDriver with Java']"));
		Reporter.log("Title of the Page is: " + title.getText(), true);
		boolean isTitleDisplayed = title.isDisplayed();
		Assert.assertTrue(isTitleDisplayed, "Title of the Page is not displaying on the page");
	}

	@Test(priority = 4)
	public void VerifyTextField() {
		WebElement textField = driver.findElement(By.name("my-text"));
		boolean isTextFieldEnabled = textField.isEnabled();
		Assert.assertTrue(isTextFieldEnabled, "Text Input Field is not enabled");
		textField.sendKeys("Ujjwal Tyagi");
	}

	@Test(priority = 5)
	public void VerifyThePassword() {
		WebElement password = driver.findElement(By.name("my-password"));
		boolean isPasswordEnabled = password.isEnabled();
		Assert.assertTrue(isPasswordEnabled, "Password Text Field is not enabled");
		password.sendKeys("ujjwal@1234");
	}

	@Test(priority = 6)
	public void DisabledInput() {
		WebElement disabledField = driver.findElement(By.name("my-disabled"));
		boolean isDisabledFieldEnabled = disabledField.isEnabled();
		Assert.assertFalse(isDisabledFieldEnabled, "My-disabled field should be disabled");
	}

	@Test(priority = 7)
	public void VerifyTheDropDown() {
		WebElement dropdown = driver.findElement(By.name("my-select"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Two");

		List<WebElement> options = select.getOptions();
		Reporter.log("Name of the Drop Down is: " + dropdown.getAttribute("name"), true);
		Reporter.log("Count of the Drop Down options is: " + options.size(), true);
	}

	@Test(priority = 8)
	public void VerifyTheCheckBoxFunctionality() {
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement checkbox : checkboxes) {
			checkbox.click();
		}
	}

	@Test(priority = 9)
	public void VerifySubmitButtonFunctionality() {
		WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		boolean isButtonDisplayed = submitButton.isDisplayed();
		boolean isButtonEnabled = submitButton.isEnabled();
		Assert.assertTrue(isButtonDisplayed, "Submit Button is not displayed");
		Assert.assertTrue(isButtonEnabled, "Submit Button is not enabled");
		submitButton.click();
	}

	@Test(priority = 10)
	public void VerifyFormSubmitMessage() {
		WebElement formSubmitMessage = driver.findElement(By.xpath("//h1[normalize-space()='Form submitted']"));
		boolean isSubmitMessageDisplayed = formSubmitMessage.isDisplayed();
		Reporter.log("Message after form submission is: " + formSubmitMessage.getText(), true);
		Assert.assertTrue(isSubmitMessageDisplayed, "Form Submit Message is not displayed");
		driver.navigate().back();
		driver.navigate().refresh();
	}

	@AfterClass
	public void TearDown() {
		driver.quit();
	}
}
