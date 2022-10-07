package ServiceNowAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		//Assignment 3:Create New Caller
				WebDriverManager.chromedriver().setup();
				ChromeOptions options=new ChromeOptions();
				options.addArguments("-disable notifications");
				ChromeDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				//1. Launch ServiceNow application
				driver.get("https://dev119133.service-now.com/");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				//2. Login with valid credentials username as admin and password as India@123
				driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
				driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Service@nowid1");
				driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
				//3. Click-All and Enter Callers in filter navigator and press enter  
				Thread.sleep(3000);
				Shadow dom=new Shadow(driver);
				dom.setImplicitWait(10);
				WebElement all = dom.findElementByXPath("//div[@class='sn-polaris-navigation polaris-header-menu']//div[1]");//div[@class='starting-header-zone']//div//div[1]
				all.click();
				WebElement filter = dom.findElementByXPath("//input[@id='filter']");
				filter.sendKeys("Callers");
				dom.findElementByXPath("//mark[@class='filter-match']").click();
				//4. Create new Caller by filling all the fields and click 'Submit'.
				driver.switchTo().frame(1);
				WebElement frame = driver.findElement(By.xpath("//button[contains(@class,'selected_action action_context')]"));
				frame.click();
				driver.switchTo().frame(1);
				WebElement firstname = driver.findElement(By.id("sys_user.first_name"));
				firstname.sendKeys("Rajalakshmi");
				driver.findElement(By.id("sys_user.last_name")).sendKeys("Maniraj");
				driver.findElement(By.id("sys_user.title")).sendKeys("Automation");
				driver.findElement(By.id("sys_user.email")).sendKeys("indiauser457@gmail.com");
				driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("9361476792");
				driver.findElement(By.id("sysverb_insert")).click();
				//5. Search and verify the newly created Caller"
				driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Rajalakshmi",Keys.ENTER);
				String name = driver.findElement(By.xpath("(//td[@class='vt'])[2]")).getText();
				if(name.contains("Rajalakshmi")) {
					System.out.println("Newly created caller is verified successfully");
				}
				else {
					System.out.println("Unable to create new caller");
				}
	}

}
