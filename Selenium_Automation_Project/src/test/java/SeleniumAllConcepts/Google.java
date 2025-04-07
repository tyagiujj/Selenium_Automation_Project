package SeleniumAllConcepts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String Title= driver.getTitle();
		System.out.println("Title of the page is : " + Title);
		
		String URL = driver.getCurrentUrl();
		System.out.println("URL of the Page is : " + URL);
		
		driver.close();
	}

}
