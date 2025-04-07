package SeleniumAllConcepts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcepts {
    public static void main(String[] args) {
       
        WebDriver driver = new ChromeDriver();
        
        driver.navigate().to("https://demoqa.com/droppable/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        Actions action = new Actions(driver);
        WebElement Drag = driver.findElement(By.id("draggable"));
        WebElement Drop = driver.findElement(By.id("droppable"));
        action.clickAndHold(Drag).moveToElement(Drop).release().build().perform();
  
        driver.quit();
    }
}
