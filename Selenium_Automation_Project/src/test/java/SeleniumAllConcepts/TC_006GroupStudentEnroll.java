package SeleniumAllConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_006GroupStudentEnroll {
	  WebDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void Setup() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        driver.get("https://dev.myschoolone.com/newworldschool");
	        driver.manage().window().maximize();

	        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	        Assert.assertTrue(usernameField.isDisplayed(), "Username field is not displayed");
	        usernameField.sendKeys("admin@mso786");

	        WebElement passwordField = driver.findElement(By.id("password"));
	        Assert.assertTrue(passwordField.isDisplayed(), "Password field is not displayed");
	        passwordField.sendKeys("38024008ec29");

	        WebElement robotCheckbox = driver.findElement(By.id("imrobot"));
	        Assert.assertTrue(robotCheckbox.isDisplayed(), "I'm not a robot checkbox is not displayed");
	        robotCheckbox.click();

	        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign')]")));
	        signInButton.click();
	    }
	    @Test(priority=1)
	    public void StudentEnroll() throws InterruptedException {
	    driver.switchTo().newWindow(WindowType.TAB);
	    Thread.sleep(3000);
	    driver.get("https://dev.myschoolone.com/Web/Dairy/Group_Student_enroll.php");
	    
	    WebElement SchoolDevision= driver.findElement(By.xpath("//select[@id='division']"));
	    Select school =new Select(SchoolDevision);
	    school.selectByVisibleText("PYP");
	    
	    WebElement Grade= driver.findElement(By.xpath("//select[@id='grade']"));
	    Select grd= new Select(Grade);
	    Thread.sleep(2000);
	    grd.selectByVisibleText("Grade1");
	    
	    WebElement Section = driver.findElement(By.id("section"));
	    Select sec= new Select(Section);
	    Thread.sleep(2000);
	    sec.selectByVisibleText("A");
	    
	    WebElement Group =driver.findElement(By.xpath("//select[@id='Studentgroup']"));
	    Select grp= new Select(Group);
	    Thread.sleep(2000);
	    grp.selectByVisibleText("Cricket");
	    
	    WebElement Add= driver.findElement(By.xpath("//button[@id='search']"));
	    Add.click();
	    driver.quit();
	    }
}
