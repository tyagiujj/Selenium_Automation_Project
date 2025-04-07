package SeleniumAllConcepts;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AutomationInterviewPractice {
	WebDriver driver;
	@Test(priority=1)
	public void Setup() {
		driver= new ChromeDriver();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	//@Test(priority=2)
	public void TextField() {
		WebElement Name= driver.findElement(By.id("name"));
		boolean name= Name.isEnabled();
		System.out.println("Name Text Field is Enabled : " + name);
		Name.sendKeys("Ujjwal");
	}
	//@Test(priority=3)
	public void GetAttribute() {
		WebElement AttributeValue= driver.findElement(By.id("email"));
		System.out.println("Value of The Attribute is : " + AttributeValue.getAttribute("placeholder"));
	}
	//@Test(priority=4)
	public void GetTextValue() {
		WebElement GetTextValue= driver.findElement(By.xpath("//span[text()=\"For Selenium, Cypress & Playwright\"]"));
		System.out.println("Get The Value : " + GetTextValue.getText());
	}
	//@Test(priority=5)
	public void TitleofThePage() {
		System.out.println("Title of The Page is : " +driver.getTitle());
	}
	//@Test(priority=6)
	public void CurrentURLofPage() {
		System.out.println("Current URL of The Page is : " + driver.getCurrentUrl());
	}
	//@Test(priority=7)
	public void PageSource() {
		System.out.println("Current Page Source of the Page is : " + driver.getPageSource());
	}
	//@Test(priority=8)
	public void WindowId() {
		System.out.println("Current Window Id of The Page is : " + driver.getWindowHandle());
	}
	//@Test(priority=9)
	public void VerifyCheckBoxFunctionality() {
		WebElement checkbox = driver.findElement(By.id("sunday"));
		boolean Box = checkbox.isEnabled();
		System.out.println("Days Check box is Enabled : " + Box);
		//checkbox.click();
		boolean box= checkbox.isSelected();
		System.out.println("Sunday Checkbox is Selected : " + box);
	}
	//@Test(priority=10)
	public void SelectMultipleCheckbox() {
	List<WebElement> checkboxs= driver.findElements(By.xpath("//input[@class=\"form-check-input\"][@type=\"checkbox\"]"));
	for(WebElement chek : checkboxs) {
		chek.click();
	}}
	@Test(priority=11)
	public void NumberofLinks() {
		//WebElement Links = driver.findElement(By.tagName("a"));
		List<WebElement> Links= driver.findElements(By.tagName("a"));
		System.out.println("Number of Links is : " + Links.size());
		
		for(WebElement link : Links ) {
			System.out.println("Name of The Links is : " + link.getText());}
		}
		//@Test(priority=12)
		public void ButtonFunctionality() {
			WebElement Button= driver.findElement(By.name("start"));
			boolean Name = Button.isDisplayed();
			System.out.println("Start Button is Dispaly : " + Name);
			boolean nme= Button.isEnabled();
			System.out.println("Start Button is Enabled : " + nme);
			Button.click();
	}
		//@Test(priority=13)
		public void ConfirmAlert() {
			WebElement cnfrm= driver.findElement(By.id("confirmBtn"));
			cnfrm.click();
			Alert alert=driver.switchTo().alert();
			System.out.println("Text Message on Confirm Alert : " + alert.getText());
		alert.accept();
		}
		//@Test(priority=14)
		public void MouseOverAction() {
			WebElement Point = driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
			WebElement Mobile = driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
			Actions act= new Actions(driver);
			act.moveToElement(Point).moveToElement(Mobile);
		}
		//@Test(priority=15)
		public void DragandDrop() {
			WebElement Drag= driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));
			WebElement Drop = driver.findElement(By.xpath("//div[@id='droppable']"));
			Actions acti= new Actions (driver);
			acti.dragAndDrop(Drag, Drop);
		}
	}


