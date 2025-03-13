package SeleniumAllConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {
   
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String currentURL = driver.getCurrentUrl();
        System.out.println("URL of The Login Page is : " + currentURL);

        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

     
        if (currentURL.equalsIgnoreCase(expectedURL)) {
            System.out.println("Test Passed: The login page URL is correct.");
        } else {
            System.out.println("Test Failed: The login page URL is incorrect.");
        }
        
        String CurrentTitle= driver.getTitle();
        System.out.println("Title of The Page is : " + CurrentTitle);
        
        String ExpectedTitle= "OrangeHRM" ;
        if(CurrentTitle.equalsIgnoreCase(ExpectedTitle)) {
        	System.out.println("Test Passed : The Title is Correct");
        }
        else {
        	System.out.println("Test Failed : The Title is Incorrect");
        }
        WebElement Username= driver.findElement(By.name("username"));
        boolean Name= Username.isEnabled();
        System.out.println("Username Text Field is Enbled : " + Name);
        Username.sendKeys("Admin");
        
        WebElement Password= driver.findElement(By.xpath("//input[@placeholder='Password']"));
        boolean password= Password.isEnabled();
        System.out.println("Password Text Field is Enabled : " + Password);
        Password.sendKeys("admin123");
        
        WebElement LoginBtn= driver.findElement(By.xpath("//button[@type='submit']"));
        boolean Btn= LoginBtn.isDisplayed();
        System.out.println("Login Button is Display : " + Btn);
        boolean Button= LoginBtn.isEnabled();
        System.out.println("Login Button is Enabled : " + Button);
        
        driver.close();
    }
}