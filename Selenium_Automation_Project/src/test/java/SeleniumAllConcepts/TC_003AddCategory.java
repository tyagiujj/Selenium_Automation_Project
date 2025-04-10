package SeleniumAllConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_003AddCategory {
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

    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void addCategory() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(4000);
        driver.get("https://dev.myschoolone.com/Web/Dairy/Add_Category.php");
        WebElement Category= driver.findElement(By.id("category_name"));
        Assert.assertTrue(Category.isDisplayed(), "Username field is not displayed");
        Assert.assertTrue(Category.isEnabled(), "Username field is not enabled");
        Category.sendKeys("IT-Supports");
        
        WebElement userType = driver.findElement(By.id("user_type"));
        Assert.assertTrue(userType.isDisplayed(), "User Type dropdown is not displayed");
        Select type = new Select(userType);
        type.selectByVisibleText("Staff");
        
        WebElement Priority= driver.findElement(By.id("priority"));
        Select Pri= new Select(Priority);
        Pri.selectByVisibleText("High");
        
        WebElement orderNo = driver.findElement(By.name("addorder_no"));
        Assert.assertTrue(orderNo.isDisplayed(), "Order No field is not displayed");
        Assert.assertTrue(orderNo.isEnabled(), "Order No field is not enabled");
        orderNo.sendKeys("1");

        WebElement saveButton = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        Assert.assertTrue(saveButton.isDisplayed(), "Save button is not displayed");
        Assert.assertTrue(saveButton.isEnabled(), "Save button is not enabled");
        saveButton.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        
        }}
}
