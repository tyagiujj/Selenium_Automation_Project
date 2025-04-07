package SeleniumAllConcepts;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class InputTextField {
	public static void main(String[] args) throws InterruptedException  {
WebDriver driver =new ChromeDriver();
driver.get("https://testautomationpractice.blogspot.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

WebElement Act_Title= driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']"));
System.out.println("Title of The Application is : " + Act_Title.getText());
 
String act_title= driver.getTitle();
System.out.println("The Actual Title of This Application is : " + act_title);

String exp_title="Automation Testing Practice";
if(act_title.equalsIgnoreCase(exp_title)) {
	System.out.println("Testing of Title is Passed");
}
else {
	System.out.println("Testing of Title is Failed");
}

List<WebElement> numberofLink= driver.findElements(By.tagName("a"));
System.out.println("The Number of Link in This Page is :  " + numberofLink.size());

for(WebElement Count : numberofLink) {
	System.out.println("Name of The Links which is Present on this page is : " + Count.getText());
	
}
List<WebElement> numberofImages= driver.findElements(By.tagName("img"));
System.out.println("The Number of Images in This Page is : " + numberofImages.size());

WebElement GUIELEMENT= driver.findElement(By.xpath("//a[normalize-space()='GUI Elements']"));
boolean GUI= GUIELEMENT.isDisplayed();
System.out.println("Name of The GUI Element is : " + GUIELEMENT.getText() );
System.out.println("THE LABEL OF GUI ELEMENT IS DISPLAY : " + GUI);

String Act_url=driver.getCurrentUrl();
System.out.println("Current URL of This Page is : " + Act_url);
String Exp_url="https://testautomationpractice.blogspot.com/";
if(Act_url.equalsIgnoreCase(Exp_url)) {
	System.out.println("Testing of The Cureent URL is Passed");
}
else {
	System.out.println("Testing of the Current URL is Failed");
}
WebElement GetAttribute= driver.findElement(By.xpath("//input[@id='name']"));
System.out.println("Value of The Attribute is : " + GetAttribute.getDomProperty("placeholder"));

WebElement Name= driver.findElement(By.xpath("//input[@id='name']"));
boolean name= Name.isEnabled();
System.out.println("The Text Input Name is Enabled : " + name);
Name.sendKeys("Ujjwal Tyagi");

WebElement Email= driver.findElement(By.xpath("//input[@id='email']"));
boolean email= Email.isEnabled();
System.out.println("The Text Input Email is Enabled : " + email);
Email.sendKeys("ujjwaltyagi9700@gmail.com");

WebElement Mobile =driver.findElement(By.xpath("//input[@id='phone']"));
boolean Phone= Mobile.isEnabled();
System.out.println("Phone Text Input field is Enalbed : " + Phone);
Mobile.sendKeys("9756360213");

WebElement Address = driver.findElement(By.xpath("//textarea[@id='textarea']"));
boolean address= Address.isEnabled();
System.out.println("The Text Input Address is Enabled : " + address);
Address.sendKeys("Bangalore Karnataka");

WebElement SimpleAlert = driver.findElement(By.xpath("//button[@id='alertBtn']"));
SimpleAlert.click();
 Alert alert= driver.switchTo().alert();
 System.out.println("Text Message on Simple Alert : " + alert.getText());
 alert.accept();
 
 WebElement ConfirmAlert= driver.findElement(By.xpath("//button[@id='confirmBtn']"));
 ConfirmAlert.click();
 Alert calert= driver.switchTo().alert();
 System.out.println("Text Message on Confirm Alert : " + calert.getText());
 calert.accept();
 
 WebElement PromptAlert= driver.findElement(By.xpath("//button[@id='promptBtn']"));
 PromptAlert.click();
 Alert palert= driver.switchTo().alert();
 palert.sendKeys("Automation Testing");
 System.out.println("Text Message on Prompt Alert : " + palert.getText());
 palert.accept();
 
WebElement SingleCheckbox = driver.findElement(By.id("sunday"));
 boolean Checkbox = SingleCheckbox.isEnabled();
 System.out.println("Check box is Enabled : " + Checkbox);
 SingleCheckbox.click();
 boolean checkbox = SingleCheckbox.isSelected();
 System.out.println("Check boc is Selected : " + checkbox);
 
 List<WebElement> MultipleCheck= driver.findElements(By.xpath("//input[@type=\"checkbox\"][@class=\"form-check-input\"]"));
 for(WebElement Checks : MultipleCheck) {
	 Checks.click();
 }
WebElement dropDown = driver.findElement(By.id("country"));
Select drp = new Select(dropDown);
drp.selectByVisibleText("Germany");
for (WebElement option : drp.getOptions()) {
  System.out.println(option.getText());
  List<WebElement> options = drp.getOptions() ;
  int count = options.size();
  System.out.println("Total number of options in the dropdown: " + count);
  }
WebElement PointMe= driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
WebElement Laptop= driver.findElement(By.xpath("//a[normalize-space()='Laptops']"));

Actions act =new Actions(driver);
act.moveToElement(PointMe).moveToElement(Laptop).click().perform();

WebElement DoubleClick= driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
Actions Double= new Actions (driver);
Double.doubleClick(DoubleClick).perform();

WebElement Drag= driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));
WebElement Drop = driver.findElement(By.xpath("//div[@id='droppable']"));
Actions drgdrp= new Actions(driver);
drgdrp.dragAndDrop(Drag, Drop).perform();

WebElement MaleRadio= driver.findElement(By.xpath("//input[@id='male']"));
boolean maleradio= MaleRadio.isEnabled();
System.out.println("Male Radio Button is Enabled : " + maleradio);
MaleRadio.click();
boolean MALE= MaleRadio.isSelected();
System.out.println("Male Radio Button is Selected : " + MALE);

WebElement Color= driver.findElement(By.id("colors"));
Select color= new Select(Color);
for (WebElement option : color.getOptions()) {
    color.selectByValue(option.getAttribute("value")); 
}

WebElement Animals = driver.findElement(By.id("animals"));
Select animals =new Select(Animals);
for(WebElement Opt : animals.getOptions()) {
	animals.selectByValue(Opt.getAttribute("value"));
}

WebElement UploadSingleFile= driver.findElement(By.id("singleFileInput"));
UploadSingleFile.sendKeys("C:\\Users\\Stuti\\Downloads\\API_Notes_002.pdf");

WebElement UploadField= driver.findElement(By.xpath("//button[normalize-space()='Upload Single File']"));
UploadField.click();

WebElement UploadMultipleFile = driver.findElement(By.id("multipleFilesInput"));
UploadMultipleFile.sendKeys("C:\\Users\\Stuti\\Downloads\\API_Notes_002.pdf\n" +
                            "C:\\Users\\Stuti\\Downloads\\DockerSetup.pdf\n" +
                            "C:\\Users\\Stuti\\Downloads\\Git+Commands.pdf");
WebElement Upload = driver.findElement(By.xpath("//button[normalize-space()='Upload Multiple Files']"));
Upload.click();
WebElement Form1= driver.findElement(By.id("input1"));
Form1.sendKeys("Ujjwal Tyagi");
WebElement Submit =driver.findElement(By.xpath("//button[@id='btn1']"));
Submit.click();

driver.findElement(By.linkText("Apple")).click();
driver.findElement(By.partialLinkText("Ap")).click();
driver.navigate().refresh();
driver.navigate().back();
driver.close();
	}
}

