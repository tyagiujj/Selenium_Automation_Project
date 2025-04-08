package SeleniumAllConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigatetoGet {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://dev.myschoolone.com/newworldschool");
        driver.manage().window().maximize();

        String firstTab = driver.getWindowHandle();
       
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://testautomationpractice.blogspot.com/");

        String secondTab = driver.getWindowHandle();

        driver.switchTo().window(firstTab);
        System.out.println("Switched to First Tab: " + driver.getTitle());

  
        driver.switchTo().window(secondTab);
        System.out.println("Switched to Second Tab: " + driver.getTitle());

        driver.quit();
    }
}
