package SeleniumAllConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverExample {

	public static void main(String[] args) {
WebDriver driver= new ChromeDriver();
driver.get("https://demoqa.com/menu#");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

Actions act= new Actions(driver);

WebElement MenuItem2= driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']"));
WebElement SubItem= driver.findElement(By.xpath("//a[text()=\"Sub Item\"]"));

act.moveToElement(MenuItem2).moveToElement(SubItem).click().perform();
	}

}
