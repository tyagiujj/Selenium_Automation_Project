package SeleniumAllConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPractice {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement Cars= driver.findElement(By.id("carselect"));
		Cars.click();
		
		Select CAR= new Select(Cars);
		CAR.selectByVisibleText("Benz");
		//CAR.selectByValue("honda");
		
		driver.close();
		
				
	

	}

}
