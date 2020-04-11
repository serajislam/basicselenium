package basicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderHandling {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		
		driver.get("http://demo.automationtesting.in/Datepicker.html");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('datepicker1').value='10/20/2020'");
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("datepicker2")).sendKeys("10/20/2020");
	}

}
