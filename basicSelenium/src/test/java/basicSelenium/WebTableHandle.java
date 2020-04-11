package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://freecrm.com/");
		
		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		
		driver.findElement(By.name("email")).sendKeys("serajislam1988@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		Thread.sleep(3000);
		
		
		// Method 1 to handle dynamic web table
		//Creating xpath
		
		//table[contains(@class,'ui celled')]/tbody[1]/tr[1]/td[2]
		//table[contains(@class,'ui celled')]/tbody[1]/tr[2]/td[2]
		//table[contains(@class,'ui celled')]/tbody[1]/tr[3]/td[2]

		String befXpath = "//table[contains(@class,'ui celled')]/tbody[1]/tr[";
		String aftXpath = "]/td[2]";
		
		
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(3000);
			String name = driver.findElement(By.xpath(befXpath +i+ aftXpath)).getText();
			System.out.println(name);
			
			//table[contains(@class,'ui celled')]/tbody[1]/tr[2]/td[1]
			if(name.contains("Numayla Islam"))
			{
				driver.findElement(By.xpath("//table[contains(@class,'ui celled')]/tbody[1]/tr["+i+"]/td[1]")).click();
			}
			
		}
		
		
		
		//driver.findElement(By.xpath("//td[contains(text(),'Seraj Islam')]//parent::tr//preceding-sibling::td//div//input[@name='id']")).click();
		
		
		
		
		
		

	}

}
