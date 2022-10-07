package ServiceNowAssignment;

import java.time.Duration;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		//Assignment 1:Ordering mobile
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
		//3. Click-AllEnter Service catalog in filter navigator and press enter 
		Thread.sleep(3000);
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		Thread.sleep(3000);
		Shadow dom=new Shadow(driver);
		dom.setImplicitWait(10);
		WebElement all = dom.findElementByXPath("//div[@class='sn-polaris-navigation polaris-header-menu']//div[1]");//div[@class='starting-header-zone']//div//div[1]
		all.click();
		//driver.findElement(By.xpath("//div[@class='sn-polaris-navigation polaris-header-menu']//div[1]")).click();//div[@class='sn-polaris-tab can-animate polaris-enabled']
		WebElement filter = dom.findElementByXPath("//input[@id='filter']");
		filter.sendKeys("Service catalog");
		dom.findElementByXPath("//span[text()='Service Catalog']").click();
		//4. Click on  mobiles
		driver.findElement(By.linkText("Mobiles")).click();
		//driver.findElement(By.xpath("(//td[@class='homepage_category_only_image_cell'])[8]")).click();
		//5.Select Apple iphone6s
		driver.findElement(By.xpath("(//a[@class='service_catalog'])[1]")).click();
		//6.Update color field to rose gold and storage field to 128GB
		driver.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[5]")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[9]")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select source=new Select(dropdown);
		source.selectByIndex(1);
		//7.Select  Order now option
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		//8.Verify order is placed and copy the request number"
		String order = driver.findElement(By.xpath("//div[@class='notification notification-success']")).getText();
		System.out.println("Verify the order: "+order);
		String reqno = driver.findElement(By.xpath("(//a[@class='linked requestItemUrl'])[1]")).getText();
		System.out.println("The request number is: "+reqno);
		
	}

}
