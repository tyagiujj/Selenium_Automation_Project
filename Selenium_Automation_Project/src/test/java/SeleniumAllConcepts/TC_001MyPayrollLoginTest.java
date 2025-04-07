package SeleniumAllConcepts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_001MyPayrollLoginTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://mypayroll.in/Login.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Login Steps
        driver.findElement(By.id("user_names")).sendKeys("beslawcollege@gmail.com");
        driver.findElement(By.id("password")).sendKeys("511879");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[@value='Login']")).click();
        Thread.sleep(3000);

        // Navigate to the Leave Page
        driver.get("https://mypayroll.in/cloud/Leaves/RMAdmin_leave.php");
        Thread.sleep(3000);

      
        WebElement dropdown = driver.findElement(By.id("select2-employee-container"));
        dropdown.click();

        // **Step 2:** Wait for the search box & enter text
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='select2-search__field']")));
        JavascriptExecutor js1=(JavascriptExecutor) driver;
        js1.executeAsyncScript("arguments[0].setAttribute('value','NAJEEBUNNISA-BESINST-026')",searchInput);
      searchInput.click();

        // **Step 3:** Wait for the dropdown option to appear & click
        Thread.sleep(2000);
        WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class, 'select2-results__option') and contains(text(), 'NAJEEBUNNISA')]")));

        // **Use JavaScriptExecutor to Click (Fix Selenium Click Issue)**
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", optionToSelect);
        js.executeScript("arguments[0].click();", optionToSelect);

        Thread.sleep(2000); // Wait to ensure selection registers

        // **Step 4:** Click outside to confirm selection
        driver.findElement(By.xpath("//h1")).click();  // Click outside the dropdown

        Thread.sleep(2000); // Wait before verifying selection

        // **Step 5:** Verify the selected value
        String selectedValue = driver.findElement(By.id("select2-employee-container")).getText();
        System.out.println("Final Selected Employee: " + selectedValue);

        // **Step 6:** Validate the selection is correct
        if (selectedValue.contains("NAJEEBUNNISA")) {
            System.out.println("Employee selection successful!");
        } else {
            System.out.println("Employee selection failed.");
        }

        // Close the browser
      //  driver.quit();
    }
}
