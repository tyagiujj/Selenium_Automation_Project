package SeleniumAllConcepts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyPayrollTest {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://mypayroll.in/login.php");
        driver.manage().window().maximize();
    }
    @Test()
    public void testMyPayrollLogin() throws InterruptedException {
        //driver.get("https://mypayroll.in/login.php");
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL of the Page: " + currentURL);
        Assert.assertEquals(currentURL, "https://mypayroll.in/login.php");
        String title = driver.getTitle();
        System.out.println("Title of MyPayroll login page is : " + title);
        Assert.assertEquals(title, "MyPayroll");
        WebElement usernameField = driver.findElement(By.id("user_names"));
        Assert.assertTrue(usernameField.isDisplayed());
        Assert.assertTrue(usernameField.isEnabled());
        usernameField.sendKeys("ujjwal@stutitechnologies.com");
        WebElement passwordField = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordField.isDisplayed());
        Assert.assertTrue(passwordField.isEnabled());
        passwordField.sendKeys("Ujjwal@1234");
        Thread.sleep(10000);
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertEquals(loginButton.getText(), "Login");
        loginButton.click();} 
    @AfterClass
    public void tearDown() {
        driver.quit(); 
    }
}
