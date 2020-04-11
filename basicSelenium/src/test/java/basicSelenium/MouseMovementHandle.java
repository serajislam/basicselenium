package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		
		driver.get("https://www.spicejet.com");
		String homePageActTitle = driver.getTitle();
		System.out.println(homePageActTitle);
		
		//creating Actions class obkject
		Actions action = new Actions(driver);
		
		//performing mouse movement action
		action.moveToElement(driver.findElement(By.id("ctl00_HyperLinkLogin"))).build().perform();
		Thread.sleep(2000);
		
		//performing mouse movement action
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'SpiceClub Members')]"))).build().perform();
		Thread.sleep(2000);
		
		//performing clicking action
		driver.findElement(By.linkText("Member Login")).click();
		Thread.sleep(2000);

	}

}
