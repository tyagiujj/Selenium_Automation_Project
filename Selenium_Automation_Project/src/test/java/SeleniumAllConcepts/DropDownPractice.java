package SeleniumAllConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPractice {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement Cars = driver.findElement(By.id("carselect"));
        Select CAR = new Select(Cars);
        List<WebElement> options = CAR.getOptions();
        int count = options.size();
        System.out.println("Total number of dropdown options: " + count);
        System.out.println("Dropdown options are:");
        for (WebElement option : options) {
        	
            System.out.println(option.getText());
        }
        CAR.selectByVisibleText("Benz");
        driver.close();
    }
}
