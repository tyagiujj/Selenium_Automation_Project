package SeleniumAllConcepts;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_001OrangeHRMLoginTest {
    WebDriver driver;
    
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority=1)
    public void testLogin() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement dashboardText = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        Assert.assertTrue(dashboardText.isDisplayed(), "Login Failed - Dashboard Not Found");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
