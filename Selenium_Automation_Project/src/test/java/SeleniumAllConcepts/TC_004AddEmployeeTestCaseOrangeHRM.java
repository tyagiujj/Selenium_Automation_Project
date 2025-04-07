package SeleniumAllConcepts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_004AddEmployeeTestCaseOrangeHRM {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void addEmployeeAndVerifyInList() {

        // Step 1: Go to Add Employee Page
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Employee"))).click();

        // Step 2: Add Employee
        String firstName = "Ujjwal";
        String lastName = "Tyagi";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName"))).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

        // Step 3: Go to Employee List
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Employee List"))).click();

      
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']")))
                .sendKeys(firstName + " " + lastName);
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

        // Step 5: Verification
        WebElement empNameCell = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='oxd-table-body']//div[@role='row']//div[contains(@class,'oxd-table-cell')][2]")));

        String actualName = empNameCell.getText();
        System.out.println("Actual Name found: " + actualName);

        Assert.assertTrue(actualName.equals(firstName + " " + lastName), "Employee not found in the Employee List!");
    }
    @AfterClass
    public void TearDown() {
    	driver.close();
    }
}
