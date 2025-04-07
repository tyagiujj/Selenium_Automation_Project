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
import org.testng.annotations.*;

public class TC_002Ealmanac {
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
    public void addDepartmentTest() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);
        driver.get("https://dev.myschoolone.com/Web/Dairy/Add_Dept.php");
        
        WebElement userName = driver.findElement(By.name("user_name"));
        Assert.assertTrue(userName.isDisplayed(), "User Name field is not displayed");
        Assert.assertTrue(userName.isEnabled(), "User Name field is not enabled");
        userName.sendKeys("Sales Team");

        WebElement userType = driver.findElement(By.id("user_type"));
        Assert.assertTrue(userType.isDisplayed(), "User Type dropdown is not displayed");
        Select type = new Select(userType);
        type.selectByVisibleText("Parent");

        WebElement status = driver.findElement(By.id("addstatusDetails"));
        Assert.assertTrue(status.isDisplayed(), "Status dropdown is not displayed");
        Select statusSelect = new Select(status);
        statusSelect.selectByValue("1");

        WebElement orderNo = driver.findElement(By.name("addorder_no"));
        Assert.assertTrue(orderNo.isDisplayed(), "Order No field is not displayed");
        Assert.assertTrue(orderNo.isEnabled(), "Order No field is not enabled");
        orderNo.sendKeys("1");

        WebElement saveButton = driver.findElement(By.id("save-department"));
        Assert.assertTrue(saveButton.isDisplayed(), "Save button is not displayed");
        Assert.assertTrue(saveButton.isEnabled(), "Save button is not enabled");
        saveButton.click();
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}