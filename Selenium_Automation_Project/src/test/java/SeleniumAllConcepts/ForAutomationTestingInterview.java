package SeleniumAllConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForAutomationTestingInterview {
	WebDriver driver;
	
	@BeforeClass
	public void Setyup() {
		driver= new ChromeDriver();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(priority=1)
	public void ValidateInputFields() {
		WebElement Name= driver.findElement(By.xpath("//input[@id='name']"));
		boolean name= Name.isEnabled();
		Assert.assertTrue(name,"Name Input Text field is not Enabled");
		Name.sendKeys("Ujjwal Tyagi");
	}
	@Test(priority=2)
	public void ButtonFunctionality() {
		WebElement StartButton= driver.findElement(By.xpath("//button[@name='start']"));
		boolean button= StartButton.isDisplayed();
		Assert.assertTrue(button,"Start Button is Display on the Page");
		boolean Btn= StartButton.isEnabled();
		Assert.assertTrue(Btn, "Start Button is not Enabled");
		StartButton.click();
	}
	@Test(priority=3)
	public void GetTheTitle() {
	String  Title= driver.getTitle();
	System.out.println("Title of The Page is : " +Title );
	Assert.assertEquals(Title, "Automation Testing Practice");
	}
	@Test(priority=4)
	public void GetURL() {
		String URL = driver.getCurrentUrl();
		System.out.println("URL of the Page is : " + URL);
		Assert.assertEquals(URL, "https://testautomationpractice.blogspot.com/");
	}
	@Test(priority=5)
	public void GetTextAndGetAttribute() {
		WebElement GetText= driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']"));
		System.out.println("Value of GetText is : " + GetText.getText());
		WebElement GetAttribute= driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']"));
		System.out.println("Value of GetAttribute is : " + GetAttribute.getAttribute("class"));
	}
	@Test(priority=6)
	public void MouseHoverAction() {
		WebElement Drag= driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));
		WebElement Drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions act= new Actions(driver);
		act.dragAndDrop(Drag, Drop).perform();
		
		WebElement Hover= driver.findElement(By.xpath("//button[@class='dropbtn']"));
		WebElement Laptop= driver.findElement(By.xpath("//a[normalize-space()='Laptops']"));
		 act.moveToElement(Hover).moveToElement(Laptop).perform();
	}
	@Test(priority = 7)
	public void SingleAndMultipleCheckBox() {
	    List<WebElement> singleCheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox'][@class='form-check-input']"));

	    for (int i = 4; i <= 6 && i < singleCheckBoxes.size(); i++) {
	        WebElement checkbox = singleCheckBoxes.get(i);
	        if (!checkbox.isSelected()) {
	            checkbox.click();
	        }}
	    }
	    @Test(priority=8)
	    public void DropDown() {
	    	WebElement DrpDown= driver.findElement(By.id("country"));
	    	Select drp= new Select(DrpDown);
	    	drp.selectByVisibleText("Canada");
	    	System.out.println("Count the number of DropDown : " + DrpDown.getText());
	    	   List<WebElement> allOptions = drp.getOptions();
	    	    System.out.println("Number of options in the dropdown: " + allOptions.size());   }
	    
	    @Test(priority=9)
	    public void NavigateMethod() {
	    	driver.navigate().to("https://myschoolone.com/bf");
	    	driver.navigate().refresh();
	    	driver.navigate().back();	
	    }
	    @Test(priority=10)
	    public void Alert() {
	    	WebElement CnfrmAlert= driver.findElement(By.xpath("//button[@id='confirmBtn']"));
	    	CnfrmAlert.click();
	    	Alert alt= driver.switchTo().alert();
	    	System.out.println("Text Message on Confirm Alert : " + alt.getText());
	    	alt.accept();
	    }
	    @Test(priority = 11)
	    public void NumberofLink() {
	        List<WebElement> numberOfLinks = driver.findElements(By.tagName("a"));
	        System.out.println("Number of Links is: " + numberOfLinks.size());

	        for (WebElement link : numberOfLinks) {
	            System.out.println("Name of the Link: " + link.getText());
	        }
	    }
@Test(priority=12)
public void LinkText() throws InterruptedException {
	//WebElement LinkText= driver.findElement(By.linkText("Lenovo"));
	WebElement PartiacalLinkText = driver.findElement(By.partialLinkText("Len"));
	PartiacalLinkText.click();
	driver.navigate().back();
}
	    
	    }

	


