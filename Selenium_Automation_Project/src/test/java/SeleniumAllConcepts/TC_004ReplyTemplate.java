package SeleniumAllConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_004ReplyTemplate {
	 WebDriver driver;
	    
	    @Parameters("browser")
	    @BeforeClass
	    public void setup(@Optional("chrome") String browser) {
	        if (browser.equalsIgnoreCase("chrome")) {
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            driver = new FirefoxDriver();
	        } else if (browser.equalsIgnoreCase("edge")) {
	            driver = new EdgeDriver();
	        }
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    @Test(priority = 1)
	    public void loginTest() {
	        driver.get("https://dev.myschoolone.com/newworldschool");
	        
	        WebElement usernameField = driver.findElement(By.name("username"));
	        Assert.assertTrue(usernameField.isDisplayed(), "Username field is not displayed");
	        Assert.assertTrue(usernameField.isEnabled(), "Username field is not enabled");
	        usernameField.sendKeys("admin@mso786");

	        WebElement passwordField = driver.findElement(By.id("password"));
	        Assert.assertTrue(passwordField.isDisplayed(), "Password field is not displayed");
	        Assert.assertTrue(passwordField.isEnabled(), "Password field is not enabled");
	        passwordField.sendKeys("38024008ec29");

	        WebElement robotCheckbox = driver.findElement(By.id("imrobot"));
	        Assert.assertTrue(robotCheckbox.isDisplayed(), "I'm not a robot checkbox is not displayed");
	        robotCheckbox.click();

	        WebElement signInButton = driver.findElement(By.xpath("//a[contains(text(),'Sign')]"));
	        Assert.assertTrue(signInButton.isDisplayed(), "Sign In button is not displayed");
	        signInButton.click();
	    }
@Test(priority=2 ,dependsOnMethods= "loginTest")
public void ReplyTemplate() throws InterruptedException {
	 driver.switchTo().newWindow(WindowType.TAB);
     Thread.sleep(4000);
     driver.get("https://dev.myschoolone.com/Web/Dairy/Reply_Template.php");
     driver.findElement(By.name("name")).sendKeys("Software Testing");
     driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title, 'Rich Text Editor')]")));
     driver.findElement(By.xpath("//body//p")).sendKeys(" Testing");
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    // wait.until(ExpectedConditions.elementToBeClickable(By.id("create-btn")));

     // Now click the button
    // driver.findElement(By.xpath("//button[@id='create-btn']")).click();
     driver.quit();
     
}


}
