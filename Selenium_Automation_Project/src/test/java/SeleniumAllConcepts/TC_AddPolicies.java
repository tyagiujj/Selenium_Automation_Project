package SeleniumAllConcepts;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_AddPolicies {

    WebDriver driver;

    @BeforeClass
    public void Setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://cloud.mypayroll.in/StagingNew/Login.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("user_names")).sendKeys("james@senboxsolutions.com");
        driver.findElement(By.id("password")).sendKeys("Kanika2008@");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
    @Test
    public void navigateToAddPolicies() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.get("https://cloud.mypayroll.in/StagingNew/cloud/Policies/Policiesnew.php");
    	driver.findElement(By.xpath("//a[@class='btn add-btn']")).click();
    	driver.findElement(By.id("PolicyName")).sendKeys("EPFO");
    	//C:\Users\Stuti\Downloads\MyPayroll_BRS_Document.pdf
    	driver.findElement(By.xpath("//input[@id='document']")).sendKeys("C:\\Users\\Stuti\\Downloads\\MyPayroll_BRS_Document.pdf");
    	driver.findElement(By.xpath("//button[@id='Savepolicies']")).click();
    }
    @AfterClass
    public void TearDown() {
    	driver.quit();
    }
}
