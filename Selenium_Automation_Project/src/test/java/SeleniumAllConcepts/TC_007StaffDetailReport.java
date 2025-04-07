package SeleniumAllConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_007StaffDetailReport {
	WebDriver driver;
	@BeforeClass
	public void Setup() {
		driver= new ChromeDriver();
		driver.get("https://dev.myschoolone.com/newworldschool");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys("admin@mso786");
		driver.findElement(By.id("password")).sendKeys("38024008ec29");
		driver.findElement(By.id("imrobot")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign')]")).click();	
	}
	@Test(priority=1)
	public void NavigatetoStaffDetailReport() throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(2000);
		driver.get("https://dev.myschoolone.com/Web/Dairy/Group_Staff_enroll.php");
		//driver.findElement(By.id("searchns")).sendKeys("001");
		WebElement Group = driver.findElement(By.id("staffgroup"));
		Select grp =new Select(Group);
		grp.selectByVisibleText("Cricket");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='searches']")).click();
		driver.quit();
		
	}}


