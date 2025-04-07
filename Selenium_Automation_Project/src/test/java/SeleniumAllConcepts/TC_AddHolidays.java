package SeleniumAllConcepts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_AddHolidays {

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

    @Test(priority = 1)
    public void NavigateToHolidayPage() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);
        driver.get("https://cloud.mypayroll.in/StagingNew/cloud/Attendance/Holiday.php");

       
        driver.findElement(By.xpath("//a[normalize-space()='Add Holiday']")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("holidayname")).sendKeys("Holi");

        driver.findElement(By.id("holidaydate")).click();
        Thread.sleep(1000);

        
        while (!driver.findElement(By.xpath("//th[@class='datepicker-switch']")).getText().contains("March")) {
            driver.findElement(By.xpath("//th[@class='next']")).click();
            Thread.sleep(500);
        }

   
        driver.findElement(By.xpath("//td[@class='day' and text()='12']")).click();
        Thread.sleep(1000);
        
        String selectedDate = driver.findElement(By.id("holidaydate")).getAttribute("value");
        System.out.println("Selected Date is: " + selectedDate);
    }
}
