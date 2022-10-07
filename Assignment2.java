package ServiceNowAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		//Asssignment 2:Create new Proposal
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
		//3. Click-AllEnter Proposal in filter navigator and press enter 
		Thread.sleep(3000);
		Shadow dom=new Shadow(driver);
		dom.setImplicitWait(10);
		WebElement all = dom.findElementByXPath("//div[@class='sn-polaris-navigation polaris-header-menu']//div[1]");//div[@class='starting-header-zone']//div//div[1]
		all.click();
		WebElement filter = dom.findElementByXPath("//input[@id='filter']");
		filter.sendKeys("Proposal");
		//4. Click- new  and  fill mandatory fields and click 'Submit' Button.
		dom.findElementByXPath("//mark[@class='filter-match']").click();
		//driver.switchTo().frame(2);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("Automate servicenow application");
		driver.findElement(By.xpath("//button[@class='form_action_button  action_context btn btn-default']")).click();
		//5. Verify the successful creation of new Proposal"
		String verify = driver.findElement(By.xpath("(//td[@class='vt'])[2]")).getText();
		if(verify.contains("Automate")) {
			System.out.println("New proposal is created successfully");
		}
		else {
			System.out.println("Unable to create new proposal");
		}


	}

}
