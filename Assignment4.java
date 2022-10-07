package ServiceNowAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Assignment4 {

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
		//3. Enter Knowledge  in filter navigator and press enter  
		Thread.sleep(3000);
		Shadow dom=new Shadow(driver);
		dom.setImplicitWait(10);
		WebElement all = dom.findElementByXPath("//div[@class='sn-polaris-navigation polaris-header-menu']//div[1]");//div[@class='starting-header-zone']//div//div[1]
		all.click();
		WebElement filter = dom.findElementByXPath("//input[@id='filter']");
		filter.sendKeys("Knowledge");
		dom.findElementByXPath("//mark[@class='filter-match']").click();
		//4. Create new Article 
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//span[@class='btn-text']")).click();
		//5.Select knowledge base as IT and category as IT- java and Click 
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']")).sendKeys("IT",Keys.ENTER);
		//driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_category']")).sendKeys("IT- java and Click");
		//6.Update the other mandatory fields
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("Automation Tester");
		//7.Select the submit option
		driver.findElement(By.xpath("//button[@class='form_action_button header  action_context btn btn-default']")).click();
	}

}
