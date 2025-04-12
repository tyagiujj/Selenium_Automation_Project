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

public class BasicHTMLForm {
	WebDriver driver;
	Duration wait= Duration.ofSeconds(10);
	@BeforeClass
	public void Setup() {
		driver= new ChromeDriver();
		driver.navigate().to("https://testpages.eviltester.com/styled/basic-html-form-test.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(wait);		
	}
	@Test(priority=1)
	public void VerifyTheURL() {
		String Act_URL= driver.getCurrentUrl();
		System.out.println("Current URL of The Application is : " + Act_URL);
		Reporter.log("Current URL of The Application is : " + Act_URL);
		Assert.assertEquals(Act_URL, "https://testpages.eviltester.com/styled/basic-html-form-test.html");
	}
	@Test(priority=2)
	public void VerifyTheTitle() {
		String Act_Title= driver.getTitle();
		System.out.println("Current Title of The Application : " + Act_Title);
		Reporter.log("Current Title of The Application : " + Act_Title);
		Assert.assertEquals(Act_Title,"HTML Form Elements");
	}
	@Test(priority=3)
	public void VerifyTitleisDisplay() {
		WebElement Title= driver.findElement(By.xpath("//h1[text()=\"Basic HTML Form Example\"]"));
	System.out.println("Title of The Page is : " + Title.getText());
	Reporter.log("Title of The Page is : " + Title.getText());
	boolean title= Title.isDisplayed();
	Assert.assertTrue(title, "Title of The Page is not Display");
	}
	@Test(priority=4)
	public void VerifyTheLink() {
		List<WebElement> NumberofLink= driver.findElements(By.tagName("a"));
		System.out.println("Number of Link Present on The Application : " + NumberofLink.size());
		Reporter.log("Number of Link Present on The Application : " + NumberofLink.size());
		for(WebElement name:  NumberofLink) {
			System.out.println("Name of The Link is : " + name.getText());
			Reporter.log("Name of The Link is : " + name.getText());
			int CountofLink= NumberofLink.size();
			Assert.assertEquals(CountofLink, 5);
		}}
		@Test(priority=5)
		public void VerifyTheUserNameField() {
			WebElement Username= driver.findElement(By.name("username"));
			boolean username= Username.isEnabled();
			Assert.assertTrue(username,"UserName Text Field is not Enabled");
			Username.sendKeys("Ujjwal");
		}
		@Test(priority=6)
		public void VerifyThePasswordTextField() {
			WebElement Password= driver.findElement(By.name("password"));
			boolean password= Password.isEnabled();
			Assert.assertTrue(password, "Password Text Field is not Enabed");
			Password.sendKeys("kumarvishwas");
		}
		@Test(priority=7)
		public void VerifyTheTextField() {
			WebElement TextField= driver.findElement(By.name("comments"));
			boolean Comments= TextField.isEnabled();
			Assert.assertTrue(Comments, "Comments Text is not Enabled");
			TextField.clear();
			TextField.sendKeys("Automation Testing Java With Selenium");
		}
		@Test(priority = 8)
		public void VerifyTheCheckboxs() {
		    List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		    for (WebElement chk : checkboxes) {
		        if (chk.isEnabled()) {
		            chk.click();
		      
		        }}}
		        @Test(priority=9)
		        public void VerifyTheSubmitButton() {
		        	WebElement Submit= driver.findElement(By.name("submitbutton"));
		        	boolean submit= Submit.isDisplayed();
		        	boolean button= Submit.isEnabled();
		        	Assert.assertTrue(submit, "Submit Button is not Dispaly");
		        	Assert.assertTrue(button, "Submit Button is not Enabled");
	Submit.click();        		
		}
		        @AfterClass
		        public void TearDown() {
		        	driver.close();
		        }
	}


