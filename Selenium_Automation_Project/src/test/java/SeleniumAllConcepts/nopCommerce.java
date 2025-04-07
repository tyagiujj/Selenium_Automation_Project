package SeleniumAllConcepts;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class nopCommerce {

	public static void main(String[] args) {
WebDriver driver= new ChromeDriver();
driver.get("https://demo.nopcommerce.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
String Act_Title= driver.getTitle();
System.out.println("Title of The Nop Commerce Application is : " + Act_Title);
String Exp_Title="nopCommerce demo store. Home page title";
if(Act_Title.equals(Exp_Title)) {
	System.out.println("Testing of  Application Title is Passed");
}
else {
	System.out.println("Testing of Application Title is Failed");
}
String Act_URL=driver.getCurrentUrl();
System.out.println("Current URL of The Application is : " + Act_URL);
String Expected_Title= "https://demo.nopcommerce.com/";
if(Act_URL.equals(Expected_Title)) {
	System.out.println("Testing of Current URL is Paased");
}
else {
	System.out.println("Testing of Current URL is Failed");
}
WebElement Logo= driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
boolean logo= Logo.isDisplayed();
System.out.println("Logo of The Application is Display : " + logo);
List<WebElement> NumberofLinks= driver.findElements(By.tagName("a"));
System.out.println("Number of The Links Which is Present on this Application : " + NumberofLinks.size());
for(WebElement Links : NumberofLinks) {
	System.out.println("Name of Links : " + Links.getText());
}
List<WebElement> Images= driver.findElements(By.tagName("img"));
System.out.println("Number of The Images Which is Present on this Application : " + Images.size());

WebElement GetAttribute= driver.findElement(By.xpath("//input[@id='small-searchterms']"));
System.out.println("Value of The Attribute is : " + GetAttribute.getAttribute("placeholder"));

WebElement Computer= driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
WebElement Laptops= driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
 Actions act=new  Actions(driver);
 act.moveToElement(Computer).moveToElement(Laptops).click().perform();
 WebElement SearchButton= driver.findElement(By.xpath("//button[normalize-space()='Search']"));
 if(SearchButton.isDisplayed()) {
	 System.out.println("Testing of Search Button Display is Passsed");
 }
 else {
	 System.out.println("Testing of Search Button Display is Failed");
 }

	}
	
}
