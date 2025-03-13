package SeleniumAllConcepts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertConcepts {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver= new ChromeDriver();
driver.get("https://demo.automationtesting.in/Alerts.html?utm_source=chatgpt.com");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
// Simple Alert
WebElement AlertWithOk= driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
AlertWithOk.click();
Alert alert= driver.switchTo().alert();
Thread.sleep(2000);
System.out.println("Text on Alert : " + alert);
alert.accept();

//Confirm Alert
WebElement ConfirmAlert= driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']"));
ConfirmAlert.click();
WebElement Confirm= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
Confirm.click();
Alert conf= driver.switchTo().alert();
System.out.println("Text message on Alert : " + conf);
conf.accept();
//conf.dismiss();

//Promt alert
WebElement promtalert= driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']"));
promtalert.click();

WebElement Promt= driver.findElement(By.xpath("//button[@class='btn btn-info']"));
Promt.click();
Alert alt= driver.switchTo().alert();
alt.sendKeys("Automation Testing");
alt.getText();
alt.accept();
//alt.dismiss();

driver.close();

	}
	

}
