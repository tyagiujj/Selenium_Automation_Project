package SeleniumAllConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandleFrames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        // Optional implicit wait if elements take time to load
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Frame 1
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.name("mytext1")).sendKeys("Welcome");
        driver.switchTo().defaultContent();

        // Frame 2
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.name("mytext2")).sendKeys("Automation");
        driver.switchTo().defaultContent();

        // Frame 3
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.name("mytext3")).sendKeys("Selenium with Java");
        driver.switchTo().defaultContent();

        // Navigate to another frame example
        driver.get("https://demo.automationtesting.in/Frames.html");
        WebElement singleFrame = driver.findElement(By.id("singleframe"));
        driver.switchTo().frame(singleFrame);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Ujjwal Tyagi");
        driver.switchTo().defaultContent();

        // Close the browser
        driver.quit();
        System.out.println("Done");
    }
}
